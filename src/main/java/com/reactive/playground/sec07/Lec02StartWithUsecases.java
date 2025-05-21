
package com.reactive.playground.sec07;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec07.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public class Lec02StartWithUsecases {
    private static final Logger log = LoggerFactory.getLogger(Lec02StartWithUsecases.class);


    public static void main(String[] args) {
        var nameGenerator = new NameGenerator();

        nameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("sam"));


        nameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("mike"));
    }

}
