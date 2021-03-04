package org.ghxiao.rxjava.intro.operators.transform;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class FlatMap {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .flatMap(x -> Observable.range(0, Math.toIntExact(x)))
                .subscribe(
                        System.out::println,
                        System.out::println,
                        () -> System.out.println("Done")
                );
        
        Thread.sleep(10_000);
    }
}
