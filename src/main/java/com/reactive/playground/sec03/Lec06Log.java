package com.reactive.playground.sec03;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec06Log {
    private static final Logger log = LoggerFactory.getLogger(Lec06Log.class);

    public static void main(String[] args) {
        Flux.range(1, 5)
                .log()
                .subscribe(Util.subscriber());
    }

}
