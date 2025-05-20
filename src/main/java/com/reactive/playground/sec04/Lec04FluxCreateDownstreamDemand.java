
package com.reactive.playground.sec04;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec01.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

// arraylist is not thread safe
// flux sink is thread safe
public class Lec04FluxCreateDownstreamDemand {
    private static final Logger log = LoggerFactory.getLogger(Lec04FluxCreateDownstreamDemand.class);

    public static void main(String[] args) {
        produceOnDemand();
    }


    public static void produceEarly () {

        var subscriber = new SubscriberImpl();
        Flux.<String>create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                var name = Util.faker().name().firstName();
                log.info("generated: {}", name);
                fluxSink.next(name);
            }
            fluxSink.complete();
        }).subscribe(subscriber);


        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);

        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(2);
    }
    private static void produceOnDemand(){
        var subscriber = new SubscriberImpl();
        Flux.<String>create(fluxSink -> {

            fluxSink.onRequest(request -> {
                for (int i = 0; i < request && !fluxSink.isCancelled(); i++) {
                    var name = Util.faker().name().firstName();
                    log.info("generated: {}", name);
                    fluxSink.next(name);
                }
            });


        }).subscribe(subscriber);


        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(2);
    }


//    public static void produceOnDemand () {
//        var subscriber = new SubscriberImpl();
//
//        Flux.<String>create(stringFluxSink -> {
//            stringFluxSink.onRequest(value -> {
//                for (int i = 0; i < value && !stringFluxSink.isCancelled(); i++) {
//                    var name = Util.faker().name().firstName();
//                    log.info("generated: {}", name);
//                    stringFluxSink.next(name);
//                }
//            });
//        }).subscribe(subscriber);
//
//        Util.sleepSeconds(2);
//        subscriber.getSubscription().request(2);
//        Util.sleepSeconds(2);
//        subscriber.getSubscription().request(2);
//        Util.sleepSeconds(2);
//        subscriber.getSubscription().cancel();
//        subscriber.getSubscription().request(2);
//    }


}
