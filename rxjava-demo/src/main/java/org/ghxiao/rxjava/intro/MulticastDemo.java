package org.ghxiao.rxjava.intro;

import io.reactivex.Flowable;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class MulticastDemo {
    public static void main(String[] args) {
        final Flowable<Long> feed = Flowable
                .interval(1, 1, TimeUnit.SECONDS)
                .share();
        feed.subscribe(data -> process("S1: "+ data));
        sleep(5000);
        feed.subscribe(data -> process("S2: "+ data));
        sleep(10000);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void process(String n) {
        System.out.println("time " + LocalDateTime.now() + " thread: " + Thread.currentThread().getName() + " processing " + n);
        sleep(1000);
        System.out.println("time " + LocalDateTime.now() + " thread: " + Thread.currentThread().getName() + " processed " + n);
        return;
    }
}
