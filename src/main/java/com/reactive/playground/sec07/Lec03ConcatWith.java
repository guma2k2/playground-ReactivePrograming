
package com.reactive.playground.sec07;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public class Lec03ConcatWith {
    private static final Logger log = LoggerFactory.getLogger(Lec03ConcatWith.class);

    public static void main(String[] args) {

    }

    private static void demo1() {
        producer1()
                .concatWithValues(-1, 0)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(3);

    }

    private static Flux<Integer> producer1() {
        return Flux.just(1, 2, 3)
                .doOnSubscribe(subscription -> log.info("subscribing to producer1"))
                .delayElements(Duration.ofMillis(10));
    }

}
