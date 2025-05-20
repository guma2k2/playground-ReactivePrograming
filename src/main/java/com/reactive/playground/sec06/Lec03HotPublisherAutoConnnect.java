
package com.reactive.playground.sec06;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec02HotPublisher {
    private static final Logger log = LoggerFactory.getLogger(Lec02HotPublisher.class);

    public static void main(String[] args) {
        var movieFlux = movieStream();
        Util.sleepSeconds(2);

        movieFlux.subscribe(Util.subscriber("subs1"));

        Util.sleepSeconds(3);


        movieFlux.subscribe(Util.subscriber("subs2"));


        Util.sleepSeconds(15);
    }


    private static Flux<String> movieStream() {
        return Flux.generate(
                () -> {
                log.info("received the request");
                return 1;
        },
                (integer, sink) -> {
                    var scene = "movie scene " + integer;
                    log.info("playing {}", scene);
                    sink.next(scene);
                    return integer++;
                }
                ).take(10)
                .delayElements(Duration.ofSeconds(10))
                .cast(String.class);
    }


}
