package org.ghxiao.rxjava.intro.operators.transform;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Window {
    public static void main(String[] args) throws InterruptedException {
        final Observable<Long> feed = Observable.interval(1, TimeUnit.SECONDS);
        final Observable<Observable<Long>> windowed = feed.window(3, TimeUnit.SECONDS);
        windowed.subscribe(w -> {
            System.out.println("A new window starts!");
            w.scan((x, y) -> x + y)
                    .subscribe(System.out::println);
        });
        Thread.sleep(10000);
    }
}
