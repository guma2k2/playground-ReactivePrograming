
package com.reactive.playground.sec05;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec04.assignment.FileReaderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.nio.file.Path;

// arraylist is not thread safe
// flux sink is thread safe
public class Lec01Handle {
    private static final Logger log = LoggerFactory.getLogger(Lec01Handle.class);

    public static void main(String[] args) {
       Flux.range(1, 10)
               .handle((item, sink) -> {
                   switch (item){
                       case 1 -> sink.next(-2);
                       case 4 -> {}
                       case 7 -> sink.error(new RuntimeException("oops"));
                       default -> sink.next(item);
                   }
               })
               .cast(Integer.class)
               .subscribe(Util.subscriber());
    }



}
