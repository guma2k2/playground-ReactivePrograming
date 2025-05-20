
package com.reactive.playground.sec04;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec01.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

// arraylist is not thread safe
// flux sink is thread safe
public class Lec04TakeOperator {
    private static final Logger log = LoggerFactory.getLogger(Lec04TakeOperator.class);

    public static void main(String[] args) {
       takeUntil();

    }

    private static void take() {
        Flux.range(1, 10)
                .log("take")
                .take(3)
                .log("subs")
                .subscribe(Util.subscriber());

    }

    private static void takeWhile () {
        Flux.range(1, 10)
                .log("take")
                .takeWhile(i -> i < 5)
                .log("sub")
                .subscribe(Util.subscriber());
    }

    private static void takeUntil() {
        Flux.range(1, 10)
                .log("take")
                .takeUntil(i -> i < 5)
                .log("sub")
                .subscribe(Util.subscriber());
    }

}
