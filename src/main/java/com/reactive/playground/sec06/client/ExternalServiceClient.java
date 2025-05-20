package com.reactive.playground.sec06.client;

import com.reactive.playground.common.AbstractHttpClient;
import com.reactive.playground.sec05.Lec02HandleUntilAssignment;
import com.reactive.playground.sec06.assignment.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Objects;

public class ExternalServiceClient extends AbstractHttpClient {

    private static final Logger log = LoggerFactory.getLogger(ExternalServiceClient.class);


    private Flux<Order> orderFlux;

    public Flux<Order> orderStream() {
        if (Objects.isNull(orderFlux)) {
            this.orderFlux = getOrderStream();
        }
        return this.orderFlux;
    }

    public Flux<Order> getOrderStream() {
        return this.httpClient.get()
                .uri("/demo04/orders/stream")
                .responseContent()
                .asString()
                .map(this::parse)
                .doOnNext(order -> log.info("{}", order))
                .publish()
                .refCount(2);
    }


    private Order parse (String message) {
        var arr = message.split(":");
        return new Order(
                arr[1],
                Integer.parseInt(arr[2]),
                Integer.parseInt(arr[3])
        );
    }
}
