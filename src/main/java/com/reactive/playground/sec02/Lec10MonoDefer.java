package com.reactive.playground.sec02;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec10MonoDefer {
    private static final Logger log = LoggerFactory.getLogger(Lec10MonoDefer.class);

    public static void main(String[] args) {
        Mono.defer(() -> cratePublisher()).subscribe(Util.subscriber());
    }

    private static Mono<Integer> cratePublisher () {

        log.info("creating publisher");
        var list = List.of(1, 2, 3);
        Util.sleepSeconds(1);
        return Mono.fromSupplier(() -> sum(list));
    }

    private static int sum (List<Integer> list) {
        log.info("finding sum of list: {}", list);
        Util.sleepSeconds(3);
        return list.stream().mapToInt(value -> value).sum();
    }

}
