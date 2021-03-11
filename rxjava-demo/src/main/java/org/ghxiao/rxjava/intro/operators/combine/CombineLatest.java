package org.ghxiao.rxjava.intro.operators.combine;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CombineLatest {
    public static void main(String[] args) throws InterruptedException {
        final Observable<Long> units = Observable.interval(1, TimeUnit.SECONDS); 
        final Observable<Long> o1 = units.filter(x -> x % 5 == 0);
        final Observable<Long> o2 = units.filter(x -> x % 3 == 0);
        final Observable<String> combined = Observable
                .combineLatest(
                        o1, 
                        o2, 
                        (v1, v2) -> String.format("%d,%d", v1, v2));
        o1.subscribe(x -> System.out.println("S1: " + x)); 
        o2.subscribe(x -> System.out.println("S2: " + x)); 
        combined.subscribe(x -> System.out.println("CD: " + x)); 
        
        Thread.sleep(20000);

    }
}
