package com.reactive.playground.sec03;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec05FluxRange {
    private static final Logger log = LoggerFactory.getLogger(Lec05FluxRange.class);

    public static void main(String[] args) {
        Flux.range(1, 10)
                .subscribe(Util.subscriber());
        Flux.range(1, 10).map(integer -> Util.faker().name().firstName())
                .subscribe(Util.subscriber());
    }

}
