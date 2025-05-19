package com.reactive.playground.sec03;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec04FluxFromStream {
    private static final Logger log = LoggerFactory.getLogger(Lec04FluxFromStream.class);

    public static void main(String[] args) {

        var list = List.of(1, 2, 3, 4);
        var stream = list.stream();
        Flux.fromStream(stream)
                .subscribe(Util.subscriber());
    }

}
