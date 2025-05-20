
package com.reactive.playground.sec04;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec04.assignment.FileReaderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.nio.file.Path;

// arraylist is not thread safe
// flux sink is thread safe
public class Lec09Assignment {
    private static final Logger log = LoggerFactory.getLogger(Lec09Assignment.class);

    public static void main(String[] args) {
        var path = Path.of("src/main/resources/sec04/file.txt");
        var fileReaderService = new FileReaderServiceImpl();
        fileReaderService.read(path)
                .take(6)
                .subscribe(Util.subscriber());
    }



}
