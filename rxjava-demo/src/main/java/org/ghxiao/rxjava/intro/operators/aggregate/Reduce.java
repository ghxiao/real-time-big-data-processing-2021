package org.ghxiao.rxjava.intro.operators.aggregate;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Reduce {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(4)
                .reduce((x, y) -> {
                    System.out.println("x="+x+" y=" + y);
                    return x + y;
                })
                .subscribe(
                        System.out::println,
                        err -> System.out.println("ERROR " + err), 
                        () -> System.out.println("DONE"));
        
        
        Thread.sleep(5000);
    }
}
