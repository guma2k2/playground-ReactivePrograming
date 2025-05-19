package com.reactive.playground.sec03;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec01.subscriber.SubscriberImpl;
import com.reactive.playground.sec03.client.ExternalServiceClient;
import com.reactive.playground.sec03.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec08NonBlockingStream {
    private static final Logger log = LoggerFactory.getLogger(Lec08NonBlockingStream.class);

    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        client
                .getNames().subscribe(Util.subscriber());
        Util.sleepSeconds(5);
    }

}
