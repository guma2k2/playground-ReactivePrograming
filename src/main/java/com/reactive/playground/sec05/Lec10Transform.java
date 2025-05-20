



package com.reactive.playground.sec05;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.UnaryOperator;

public class Lec10Transform {
    private static final Logger log = LoggerFactory.getLogger(Lec10Transform.class);


    record Customer(int id, String name){}
    record PurchaseOrder(String productName, int price, int quantity){}
    public static void main(String[] args) {
        getCustomers()
                .transform(addDebugger())
                .subscribe(Util.subscriber());

        getPurchaseOrders()
                .transform(addDebugger())
                .subscribe(Util.subscriber());
    }


    private static Flux<Customer> getCustomers() {
        return Flux.range(1, 3)
                .map(i -> new Customer(i, Util.faker().name().firstName()));
    }

    private static Flux<PurchaseOrder> getPurchaseOrders() {
        return Flux.range(1, 5)
                .map(i -> new PurchaseOrder(Util.faker().commerce().productName(), i , i * 10));
    }


    private static <T>UnaryOperator<Flux<T>> addDebugger () {
        return tFlux -> tFlux
                .doOnNext(i -> log.info("received : {}" , i))
                .doOnComplete(() -> log.info("completed"))
                .doOnError(err -> log.error("error", err));
    }


}
