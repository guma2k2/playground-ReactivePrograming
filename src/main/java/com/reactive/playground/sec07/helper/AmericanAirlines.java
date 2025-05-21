package com.reactive.playground.sec07.helper;

import com.reactive.playground.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class AmericanAirlines {
    private static final String AIRLINE = "AmericanAirlines";

    public static Flux<Flight> getFlights() {
        return Flux.range(1, Util.faker().random().nextInt(5, 10))
                .delayElements(Duration.ofMillis(Util.faker().random().nextInt(200, 1200)))
                .map(i -> new Flight(AIRLINE, Util.faker().random().nextInt(400,900)))
                .transform(Util.fluxLogger(AIRLINE));
    }
}
