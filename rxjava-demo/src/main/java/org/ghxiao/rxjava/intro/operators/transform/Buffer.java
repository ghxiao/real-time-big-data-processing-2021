package org.ghxiao.rxjava.intro.operators.transform;

import io.reactivex.Observable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Buffer {
    public static void main(String[] args) throws InterruptedException {
        final Observable<Long> feed
                = Observable.interval(1, TimeUnit.SECONDS);
        feed.subscribe(v -> {
            System.out.println("original: time="
                    + LocalDateTime.now() + ", value=" + v);
        });
        final Observable<List<Long>> buffered
                = feed.buffer(3, TimeUnit.SECONDS);
        buffered.subscribe(v -> {
            System.out.println("buffered: time="
                    + LocalDateTime.now() + ", value=" + v);
        });
        Thread.sleep(10000);

    }
}
