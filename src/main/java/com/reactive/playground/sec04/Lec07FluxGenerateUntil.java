
package com.reactive.playground.sec04;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

// arraylist is not thread safe
// flux sink is thread safe
public class Lec06FluxGenerate {
    private static final Logger log = LoggerFactory.getLogger(Lec06FluxGenerate.class);

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            synchronousSink.next(1);
            synchronousSink.next(2);
            synchronousSink.complete();
        }).subscribe(Util.subscriber());
    }

}
