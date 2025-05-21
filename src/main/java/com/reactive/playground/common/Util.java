package com.reactive.playground.common;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.UnaryOperator;

public class Util   {

    private static final Logger log = LoggerFactory.getLogger(Util.class);


    private static final Faker faker = Faker.instance();
    public static <T>Subscriber<T> subscriber() {
        return new DefaultSubscriber<>("");
    }

    public static <T>Subscriber<T> subscriber(String name) {
        return new DefaultSubscriber<>(name);
    }

    public static Faker faker () {
        return faker;
    }


    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static <T>UnaryOperator<Flux<T>> fluxLogger (String name) {
        return tFlux -> tFlux
                .doOnSubscribe(s -> log.info("subscribing to {}", name) )
                .doOnCancel(() -> log.info("canceling {}", name))
                .doOnComplete(() -> log.info("{} completed" , name ));
    }
}
