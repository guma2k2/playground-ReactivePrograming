package com.reactive.playground.sec03;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec03FluxFromIterable {
    private static final Logger log = LoggerFactory.getLogger(Lec03FluxFromIterable.class);

    public static void main(String[] args) {
        var list = List.of("a", "b", "c");
        Flux.fromIterable(list).subscribe(Util.subscriber());

        Integer[] arr = {1, 2, 3, 4};
        Flux.fromArray(arr).subscribe(Util.subscriber());
    }

}
