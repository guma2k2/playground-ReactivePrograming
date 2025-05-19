package com.reactive.playground.sec03;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec09FluxEmptyError {
    private static final Logger log = LoggerFactory.getLogger(Lec09FluxEmptyError.class);

    public static void main(String[] args) {
        Flux.empty()
                .subscribe(Util.subscriber());

        Flux.error(new RuntimeException("oops"))
                .subscribe(Util.subscriber());
    }

}
