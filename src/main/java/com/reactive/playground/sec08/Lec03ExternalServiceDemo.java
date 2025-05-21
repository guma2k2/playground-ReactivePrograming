




package com.reactive.playground.sec08;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec08.client.ExternalServiceClient;
import com.reactive.playground.sec08.client.ServerError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.util.retry.Retry;

import java.time.Duration;

public class
Lec03ExternalServiceDemo {
    private static final Logger log = LoggerFactory.getLogger(Lec03ExternalServiceDemo.class);


    public static void main(String[] args) {
        repeat();
        Util.sleepSeconds(60);
    }


    private static void repeat () {
        var client = new ExternalServiceClient();

        client.getCountry()
                .repeat()
                .takeUntil(c -> c.equalsIgnoreCase("canada"))
                .subscribe(Util.subscriber());
    }


    private static void retry () {
        var client = new ExternalServiceClient();

        client.getProductName(1)
                .retryWhen(retryOnServerError())
                .subscribe(Util.subscriber());
    }

    private static Retry retryOnServerError() {
        return Retry
                .fixedDelay(20, Duration.ofSeconds(1))
                .filter(ex -> ServerError.class.equals(ex.getClass()))
                .doBeforeRetry(rs -> log.info("retrying {}", rs.failure().getMessage()));
    }
}
