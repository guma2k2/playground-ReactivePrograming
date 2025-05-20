
package com.reactive.playground.sec04;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

// arraylist is not thread safe
// flux sink is thread safe
public class Lec08GenerateWithState {
    private static final Logger log = LoggerFactory.getLogger(Lec08GenerateWithState.class);

    public static void main(String[] args) {
        Flux.generate(
                () -> 0,
                (counter, sink) -> {
                    var country = Util.faker().country().name();
                    sink.next(country);
                    counter++;
                    if (counter == 20 || country.equalsIgnoreCase("canada")) {
                        sink.complete();
                    }
                    return counter;
                }
        ).subscribe(Util.subscriber());
    }



}
