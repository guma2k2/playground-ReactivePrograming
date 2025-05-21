

package com.reactive.playground.sec07;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec07.applications.OrderService;
import com.reactive.playground.sec07.applications.UserService;
import com.reactive.playground.sec07.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec11FluxFlatMapAssignment {
    private static final Logger log = LoggerFactory.getLogger(Lec11FluxFlatMapAssignment.class);


    public static void main(String[] args) {

        var client = new ExternalServiceClient();

        Flux.range(1, 10)
                .flatMap(client::getProduct)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(2);
    }


}
