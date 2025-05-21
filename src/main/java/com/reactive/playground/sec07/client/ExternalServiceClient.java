package com.reactive.playground.sec07.client;

import com.reactive.playground.common.AbstractHttpClient;
import com.reactive.playground.sec06.assignment.Order;
import com.reactive.playground.sec07.assignment.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class ExternalServiceClient extends AbstractHttpClient {

    private static final Logger log = LoggerFactory.getLogger(ExternalServiceClient.class);

    public Mono<Product> getProduct(int productId) {
        return Mono.zip(getProductName(productId), getReview(productId), getPrice(productId))
                .map(t -> new Product(t.getT1(), t.getT2(), t.getT3()));
    }


    private Mono<String> getProductName(int productId) {
        return get("/demo05/product/" + productId);
    }


    private Mono<String> getReview(int productId) {
        return get("/demo05/review/" + productId);
    }

    private Mono<String> getPrice(int productId) {
        return get("/demo05/price/" + productId);
    }

    private Mono<String> get(String path) {
        return this.httpClient.get()
                .uri(path)
                .responseContent()
                .asString()
                .next();
    }


}
