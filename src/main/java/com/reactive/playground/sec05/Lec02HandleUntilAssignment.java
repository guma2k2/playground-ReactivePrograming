
package com.reactive.playground.sec05;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec02HandleUntilAssignment {
    private static final Logger log = LoggerFactory.getLogger(Lec02HandleUntilAssignment.class);

    public static void main(String[] args) {
       Flux.<String>generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
               .handle((item, sink) -> {
                   sink.next(item);
                   if (item.equalsIgnoreCase("canada")) {
                       sink.complete();
                   }
               }).subscribe(Util.subscriber());
    }



}
