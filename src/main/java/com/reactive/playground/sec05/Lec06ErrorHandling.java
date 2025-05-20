

package com.reactive.playground.sec05;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06ErrorHandling {
    private static final Logger log = LoggerFactory.getLogger(Lec06ErrorHandling.class);

    public static void main(String[] args) {
        Flux.range(1, 10)
                .map(i -> i == 5 ? i / 0 : i)
                .onErrorContinue((ex, obj) -> log.error("==> {}", obj, ex))
                .subscribe(Util.subscriber());
    }

    private static void onErrorComplete() {
        Mono.just(1)
                .onErrorComplete()
                .subscribe(Util.subscriber());
    }

    private static void onErrorReturn () {
        Flux.range(1, 10)
                .map(i -> i == 5 ? 5/0 : i)
                .onErrorReturn(IllegalArgumentException.class, -1)
                .onErrorReturn(ArithmeticException.class, -1)
                .subscribe(Util.subscriber());
    }

    private static void onErrorResume () {
        Mono.just(5)
                .map(i -> i / 0)
                .onErrorResume(ex -> fallback())
                .subscribe(Util.subscriber());
    }


    private static Mono<Integer> fallback () {
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(10, 100));
    }



}
