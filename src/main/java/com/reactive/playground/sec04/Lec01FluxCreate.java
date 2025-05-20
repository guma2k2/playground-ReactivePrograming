package com.reactive.playground.sec04;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    private static final Logger log = LoggerFactory.getLogger(Lec01FluxCreate.class);

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker().country().name();
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("canada"));
            fluxSink.complete();
        })
                .subscribe(Util.subscriber());
    }

}
