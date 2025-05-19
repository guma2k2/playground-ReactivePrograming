package com.reactive.playground.sec03;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec01.subscriber.SubscriberImpl;
import com.reactive.playground.sec03.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec07FluxVsList {
    private static final Logger log = LoggerFactory.getLogger(Lec07FluxVsList.class);

    public static void main(String[] args) {
//        var list =  NameGenerator.getNamesList(10);
//        System.out.println(list);

        var subscriber = new SubscriberImpl();

        NameGenerator.getNamesFlux(10).subscribe(subscriber);
        subscriber.getSubscription().request(3);
        
    }

}
