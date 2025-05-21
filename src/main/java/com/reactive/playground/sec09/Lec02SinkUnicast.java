
package com.reactive.playground.sec09;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;


public class Lec02SinkUnicast {
    private static final Logger log = LoggerFactory.getLogger(Lec02SinkUnicast.class);

    public static void main(String[] args) {


    }

    private static void demo1() {
        var sink = Sinks.many().unicast().onBackpressureBuffer();

        var flux = sink.asFlux();

        sink.tryEmitNext("hi");

        flux.subscribe(Util.subscriber("sam"));
    }


    private static void demo2() {
        var sink = Sinks.many().unicast().onBackpressureBuffer();

        var flux = sink.asFlux();

        sink.tryEmitNext("hi");

        flux.subscribe(Util.subscriber("sam"));

        flux.subscribe(Util.subscriber("mike"));

    }








}
