


package com.reactive.playground.sec07;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec07.applications.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class Lec16Assignment {
    private static final Logger log = LoggerFactory.getLogger(Lec16Assignment.class);

    record UserInformation(Integer userId, String username, Integer balance, List<Order> orders){}

    public static void main(String[] args) {


        UserService.getAllUsers()
                .flatMap(user -> getUserInformation(user))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(2);
    }

    private static Mono<UserInformation> getUserInformation(User user) {
        return Mono.zip(
                PaymentService.getUserBalance(user.id()),
                OrderService.getUserOrders(user.id()).collectList()
        )
                .map(t -> new UserInformation(user.id(), user.name(), t.getT1(), t.getT2()));
    }

}
