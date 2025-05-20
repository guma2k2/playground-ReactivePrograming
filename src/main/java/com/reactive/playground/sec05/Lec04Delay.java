
package com.reactive.playground.sec05;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec04Delay {
    private static final Logger log = LoggerFactory.getLogger(Lec04Delay.class);

    public static void main(String[] args) {
       Flux.range(1, 10)
               .log()
               .delayElements(Duration.ofSeconds(1))
               .subscribe(Util.subscriber());

       Util.sleepSeconds(12);



    }



}
