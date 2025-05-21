


package com.reactive.playground.sec08;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class
Lec02Retry {
    private static final Logger log = LoggerFactory.getLogger(Lec02Retry.class);


    public static void main(String[] args) {


        Util.sleepSeconds(10);
    }

    private static void demo1 () {
        getCountryName()
                .retry(1)
                .subscribe(Util.subscriber());
    }


    private static void demo2 () {
        getCountryName()
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(1))
                        .doBeforeRetry(rs -> log.info("retrying")))
                .subscribe(Util.subscriber());
    }

    private static Mono<String> getCountryName () {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        return Mono.fromSupplier(() -> {
            if (atomicInteger.incrementAndGet() < 3) {
                throw new RuntimeException("oops");
            }
            return Util.faker().country().name();
        })
                .doOnError(err -> log.info("ERR: {}", err.getMessage()))
                .doOnSubscribe(s -> log.info("subscribing"));
    }
}
