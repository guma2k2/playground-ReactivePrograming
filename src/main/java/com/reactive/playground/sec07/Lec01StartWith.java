package com.reactive.playground.sec07;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public class Lec01StartWith {
    private static final Logger log = LoggerFactory.getLogger(Lec01StartWith.class);


    public static void main(String[] args) {
        producer1()
                .startWith(-1, 0)
                .subscribe(Util.subscriber());

    }

    private static void demo1() {
        producer1()
                .startWith(-1, 0)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(3);

    }

    private static void demo2() {
        producer1()
                .startWith(List.of(1, 2, 3))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(3);

    }

    private static Flux<Integer> producer1() {
        return Flux.just(1, 2, 3)
                .doOnSubscribe(subscription -> log.info("subscribing to producer1"))
                .delayElements(Duration.ofMillis(10));
    }

}
