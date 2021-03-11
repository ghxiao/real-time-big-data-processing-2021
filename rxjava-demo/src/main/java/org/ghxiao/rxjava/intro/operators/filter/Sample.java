package org.ghxiao.rxjava.intro.operators.filter;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Sample {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS) 
                .sample(4, TimeUnit.SECONDS) .subscribe(
                System.out::println,
                err -> System.out.println("ERROR " + err), () -> System.out.println("DONE"));
        Thread.sleep(20000);
    }
}
