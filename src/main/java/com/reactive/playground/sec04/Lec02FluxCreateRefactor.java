
package com.reactive.playground.sec04;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec04.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactor {
    private static final Logger log = LoggerFactory.getLogger(Lec02FluxCreateRefactor.class);

    public static void main(String[] args) {
       var generator = new NameGenerator();
       var flux = Flux.create(generator);
       flux.subscribe(Util.subscriber());


        for (int i = 0; i < 10; i++) {
            generator.generate();
        }
    }

}
