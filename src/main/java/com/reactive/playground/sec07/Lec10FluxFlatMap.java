

package com.reactive.playground.sec07;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec07.applications.OrderService;
import com.reactive.playground.sec07.applications.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec10FluxFlatMap {
    private static final Logger log = LoggerFactory.getLogger(Lec10FluxFlatMap.class);


    public static void main(String[] args) {

        UserService.getAllUsers()
                .map(user -> user.id())
                        .flatMap(userId -> OrderService.getUserOrders(userId))
                .subscribe(Util.subscriber());
        Util.sleepSeconds(2);
    }


}
