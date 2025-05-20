


package com.reactive.playground.sec05;

import com.github.javafaker.Faker;
import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec08SwtichfEmpty {
    private static final Logger log = LoggerFactory.getLogger(Lec08SwtichfEmpty.class);

    public static void main(String[] args) {
        Flux.range(1, 10)
                .filter(i -> i > 11)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> fallback() {
        return Flux.range(100, 3);
    }



}
