package org.ghxiao.rxjava.intro.operators.filter;

import io.reactivex.Observable;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Debounce {
    public static void main(String[] args) throws InterruptedException {
        final Observable<Long> feed = Observable
                .interval(1, 200, TimeUnit.MILLISECONDS)
                .filter(x -> new Random().nextInt(32) < 16);
        
        feed.subscribe(
                x -> System.out.println("feed: time=" + LocalDateTime.now() + " value=" + x), 
                err -> System.out.println("ERROR " + err),
                () -> System.out.println("DONE"));
        
        final Observable<Long> debounced = feed.debounce(500, TimeUnit.MILLISECONDS);
        debounced.subscribe(x -> System.out.println("debounced: time=" + LocalDateTime.now() + " value=" + x),
                err -> System.out.println("ERROR " + err),
                () -> System.out.println("DONE"));
        
        Thread.sleep(10000);
    }
}
