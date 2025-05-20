
package com.reactive.playground.sec04;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

// arraylist is not thread safe
// flux sink is thread safe
public class Lec07FluxGenerateUntil {
    private static final Logger log = LoggerFactory.getLogger(Lec07FluxGenerateUntil.class);

    public static void main(String[] args) {
      demo2();
    }

    private static void demo1() {
        Flux.generate(synchronousSink -> {
            var country = Util.faker().country().name();
            synchronousSink.next(country);
            if (country.equalsIgnoreCase("canada")) {
                synchronousSink.complete();
            }
        }).subscribe(Util.subscriber());
    }

    private static void demo2() {
        Flux.generate(synchronousSink -> {
            var country = Util.faker().country().name();
            synchronousSink.next(country);

        })
                .takeUntil(c -> c.equals("Canada"))
                .subscribe(Util.subscriber());
    }

}
