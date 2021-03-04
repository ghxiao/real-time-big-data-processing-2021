package org.ghxiao.rxjava.intro.operators.transform;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Scan {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .scan((x, y) -> {
                    System.out.println("x="+x+" y=" + y);
                    return x + y;
                })
                .subscribe(
                        System.out::println,
                        err -> System.out.println("ERROR " + err), () -> System.out.println("DONE"));
        Thread.sleep(5000);
    }
}
