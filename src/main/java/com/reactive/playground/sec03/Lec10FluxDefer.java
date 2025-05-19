package com.reactive.playground.sec03;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec03.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec09FluxInterval {
    private static final Logger log = LoggerFactory.getLogger(Lec09FluxInterval.class);

    public static void main(String[] args) {
        Flux.interval(Duration.ofMillis(500))
                .subscribe(Util.subscriber());
        Util.sleepSeconds(5);
    }

}
