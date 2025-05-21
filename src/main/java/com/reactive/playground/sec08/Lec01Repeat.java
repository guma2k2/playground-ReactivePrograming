

package com.reactive.playground.sec08;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class
Lec01Repeat {
    private static final Logger log = LoggerFactory.getLogger(Lec01Repeat.class);


    public static void main(String[] args) {

    }

    private static void demo1 () {
        getCountryName()
                .repeat(3)
                .subscribe(Util.subscriber());
    }

    private static void demo2 () {
        getCountryName()
                .repeat()
                .takeUntil(c -> c.equalsIgnoreCase("canada"))
                .subscribe(Util.subscriber());
    }


    private static void demo3 () {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        getCountryName()
                .repeat(() -> atomicInteger.getAndIncrement() < 3)
                .subscribe(Util.subscriber());
    }

    private static void demo4 () {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        getCountryName()
                .repeatWhen(flux -> flux.delayElements(Duration.ofSeconds(2)).take(2))
                .subscribe(Util.subscriber());
    }


    private static Mono<String> getCountryName () {
        return Mono.fromSupplier(() -> Util.faker().country().name());
    }
}
