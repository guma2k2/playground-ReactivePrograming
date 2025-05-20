


package com.reactive.playground.sec05;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec07DefaultIfEmpty {
    private static final Logger log = LoggerFactory.getLogger(Lec07DefaultIfEmpty.class);

    public static void main(String[] args) {
        Mono.empty()
                .defaultIfEmpty("fallback")
                .subscribe(Util.subscriber());
    }



}
