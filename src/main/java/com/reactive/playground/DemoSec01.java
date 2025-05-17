package com.reactive.playground;

import com.reactive.playground.sec01.publisher.PublisherImpl;
import com.reactive.playground.sec01.subscriber.SubscriberImpl;

public class DemoSec01 {
    public static void main(String[] args) throws InterruptedException {
        demo4();
    }


    private static  void demo1 () {
        PublisherImpl publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    private static void demo2 () throws InterruptedException {
        PublisherImpl publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3L);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3L);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3L);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3L);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3L);

    }

    private static void demo3 () throws InterruptedException {
        PublisherImpl publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3L);
        Thread.sleep(2000);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(3L);
        Thread.sleep(2000);

    }

    private static void demo4 () throws InterruptedException {
        PublisherImpl publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3L);
        Thread.sleep(2000);
        subscriber.getSubscription().request(11L);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3L);
        Thread.sleep(2000);


    }
    //         Thread.sleep(2000);
}
