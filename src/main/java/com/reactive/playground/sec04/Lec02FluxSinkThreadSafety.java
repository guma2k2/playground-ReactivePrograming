
package com.reactive.playground.sec04;

import com.github.javafaker.Faker;
import com.reactive.playground.common.Util;
import com.reactive.playground.sec04.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

// arraylist is not thread safe
// flux sink is thread safe
public class Lec02FluxSinkThreadSafety {
    private static final Logger log = LoggerFactory.getLogger(Lec02FluxSinkThreadSafety.class);

    public static void main(String[] args) {

        demo2();
    }

    private static void demo1() {
        var list = new ArrayList<>();
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };


        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(3);

        log.info("list size: {}", list.size());
    }


    private static void demo2 ( ) {
        var list = new ArrayList<>();
        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(list::add);


        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                generator.generate();
            }
        };


        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(3);

        log.info("list size: {}", list.size());

    }
}
