package com.reactive.playground.sec03;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec03.assignment.StockPriceObserver;
import com.reactive.playground.sec03.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec12Asignment {
    private static final Logger log = LoggerFactory.getLogger(Lec12Asignment.class);

    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        var subscriber = new StockPriceObserver();
        client.getPriceChanges().subscribe(subscriber);
        Util.sleepSeconds(20);

    }

}
