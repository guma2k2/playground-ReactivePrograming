




package com.reactive.playground.sec05;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec05.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.function.UnaryOperator;

public class Lec11Assignment {
    private static final Logger log = LoggerFactory.getLogger(Lec11Assignment.class);


    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        for (int i = 0; i < 5; i++) {
            client.getProductName(i).subscribe(Util.subscriber());
        }

        Util.sleepSeconds(3);
    }

}
