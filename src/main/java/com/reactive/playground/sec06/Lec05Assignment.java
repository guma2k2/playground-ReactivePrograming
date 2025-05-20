
package com.reactive.playground.sec06;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec06.assignment.InventoryService;
import com.reactive.playground.sec06.assignment.RevenueService;
import com.reactive.playground.sec06.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec05Assignment {
    private static final Logger log = LoggerFactory.getLogger(Lec05Assignment.class);

    public static void main(String[] args) {

        var client = new ExternalServiceClient();
        var inventoryService = new InventoryService();
        var revenueService = new RevenueService();

        client.orderStream().subscribe(inventoryService::consume);
        client.orderStream().subscribe(revenueService::consume);

        inventoryService.stream()
                .subscribe(Util.subscriber("inventory"));

        revenueService.stream()
                .subscribe(Util.subscriber("revenue"));


        Util.sleepSeconds(30);
    }



}
