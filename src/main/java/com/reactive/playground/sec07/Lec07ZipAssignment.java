
package com.reactive.playground.sec07;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec07.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07ZipAssignment {
    private static final Logger log = LoggerFactory.getLogger(Lec07ZipAssignment.class);


    public static void main(String[] args) {
        var client = new ExternalServiceClient();

        for (int i = 0; i < 10; i++) {
            client.getProduct(i).subscribe(Util.subscriber());
        }

        Util.sleepSeconds(2);
    }


}
