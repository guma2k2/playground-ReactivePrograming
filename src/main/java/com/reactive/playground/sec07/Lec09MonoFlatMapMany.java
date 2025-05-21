
package com.reactive.playground.sec07;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec07.applications.PaymentService;
import com.reactive.playground.sec07.applications.UserService;
import com.reactive.playground.sec07.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec08MonoFlatMap {
    private static final Logger log = LoggerFactory.getLogger(Lec08MonoFlatMap.class);


    public static void main(String[] args) {
        UserService.getUserId("sam")
                .flatMap(userId -> PaymentService.getUserBalance(userId))
                .subscribe(Util.subscriber());
    }


}
