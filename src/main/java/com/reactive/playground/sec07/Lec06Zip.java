
package com.reactive.playground.sec07;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec04Merge {
    private static final Logger log = LoggerFactory.getLogger(Lec04Merge.class);

    public static void main(String[] args) {

        Flux.merge(producer1(), producer2(), producer3())
                .take(2)
                .subscribe(Util.subscriber());

        producer1().mergeWith(producer2()).mergeWith(producer3())
                        .take(2)
                                .subscribe(Util.subscriber());


        Util.sleepSeconds(3);
    }

    private static Flux<Integer> producer1() {
        return Flux.just(1, 2, 3)
                .transform(Util.fluxLogger("producer3"))
                .delayElements(Duration.ofMillis(10));
    }


    private static Flux<Integer> producer2() {
        return Flux.just(11, 12, 13)
                .transform(Util.fluxLogger("producer3"))
                .delayElements(Duration.ofMillis(10));
    }


    private static Flux<Integer> producer3() {
        return Flux.just(21, 22, 23)
                .transform(Util.fluxLogger("producer3"))
                .delayElements(Duration.ofMillis(10));
    }

}
