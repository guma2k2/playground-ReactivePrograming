package com.reactive.playground.sec02;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec02.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec11NonBlockingIO {
    private static final Logger log = LoggerFactory.getLogger(Lec11NonBlockingIO.class);

    public static void main(String[] args) {
        var client = new ExternalServiceClient();
//        client.getProductName(1)
//                .subscribe(Util.subscriber());
//        log.info("starting");
//
        for(int i = 0; i <= 5; i++){
            client.getProductName(i)
                    .subscribe(Util.subscriber());
        }
        Util.sleepSeconds(2);
    }

}
