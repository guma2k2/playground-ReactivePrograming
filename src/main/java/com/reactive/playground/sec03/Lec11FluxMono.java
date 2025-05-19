package com.reactive.playground.sec03;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Lec11FluxMono {
    private static final Logger log = LoggerFactory.getLogger(Lec11FluxMono.class);

    public static void main(String[] args) {

        Flux<Integer> range = Flux.range(1, 10);
        Mono.from(range)
                .subscribe(Util.subscriber());

    }

    private static void monoToFlux () {
        var mono = getUsername(1);
        save(Flux.from(mono));
    }

    private static Mono<String> getUsername(int userId) {
        return switch (userId) {
            case 1 -> Mono.just("sam");
            case 2 -> Mono.empty(); // null
            default ->  Mono.error(new RuntimeException("Invalid input" ));
        };
    }

    private static void save (Flux<String> flux) {
        flux.subscribe(Util.subscriber());
    }
}
