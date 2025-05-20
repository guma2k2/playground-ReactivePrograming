
package com.reactive.playground.sec06;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec04HotPublisherCache {
    private static final Logger log = LoggerFactory.getLogger(Lec04HotPublisherCache.class);

    public static void main(String[] args) {
        var stockFlux = stockStream().replay(1).autoConnect(0);
        Util.sleepSeconds(4);

        log.info("sam joining");
        stockFlux.subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(3);

        log.info("mike joining");
        stockFlux.subscribe(Util.subscriber("mike"));


        Util.sleepSeconds(15);
    }


    private static Flux<Integer> stockStream() {
        return Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().random().nextInt(10, 199)))
                .delayElements(Duration.ofSeconds(3))
                .doOnNext(o -> log.info("emitting price {}", o))
                .cast(Integer.class);
    }


}
