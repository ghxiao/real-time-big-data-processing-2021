package org.ghxiao.rxjava.intro.operators.combine;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Join {
    public static void main(String[] args) throws InterruptedException {
        final Observable<Long> units = Observable .interval(1, TimeUnit.SECONDS);
        final Observable<Long> o1 = units .filter(x -> x % 2 == 0);
        final Observable<Long> o2 = units .filter(x -> x % 3 == 0);
        final Observable<String> joined = o1.join(o2,
                (x) -> Observable.timer(2, TimeUnit.SECONDS), 
                (y) -> Observable.timer(1, TimeUnit.SECONDS), 
                (u, v) -> String.format("%s,%s", u, v)
        );
        o1.subscribe(x -> System.out.println("S1: " + x)); 
        o2.subscribe(x -> System.out.println("S2: " + x)); 
        joined.subscribe(x -> System.out.println("JD: " + x)); 
        Thread.sleep(20000);
    }
}
