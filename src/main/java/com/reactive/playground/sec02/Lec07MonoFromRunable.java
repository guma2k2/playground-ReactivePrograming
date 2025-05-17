package com.reactive.playground.sec02;

import com.reactive.playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec07MonoFromRunable {
    private static final Logger log = LoggerFactory.getLogger(Lec07MonoFromRunable.class);

    public static void main(String[] args) {

      getProductName(2).subscribe(Util.subscriber() );
    }

    private static Mono<String> getProductName(int productId) {
        if (productId == 1) {
            return Mono.fromSupplier(() -> Util.faker().commerce().productName());
        }
        return Mono.fromRunnable(() -> notifyBusinees(productId));
    }

    private static void notifyBusinees(int productId) {
        log.info("notifying business on unavailable product: {}", productId);
    }

}
