package com.reactive.playground.sec02;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec09MonoCreateVsExecution {
    private static final Logger log = LoggerFactory.getLogger(Lec09MonoCreateVsExecution.class);

    public static void main(String[] args) {
        getName().subscribe(Util.subscriber());
    }
    private static Mono<String> getName() {
        return Mono.fromSupplier(() -> {
            log.info("generating name");
            return Util.faker().name().firstName();
        });
    }

}
