

package com.reactive.playground.sec07;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec07.applications.OrderService;
import com.reactive.playground.sec07.applications.PaymentService;
import com.reactive.playground.sec07.applications.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec09MonoFlatMapMany {
    private static final Logger log = LoggerFactory.getLogger(Lec09MonoFlatMapMany.class);


    public static void main(String[] args) {

        UserService.getUserId("sam")
                .flatMapMany(userId -> OrderService.getUserOrders(userId))
                .subscribe(Util.subscriber());
    }


}
