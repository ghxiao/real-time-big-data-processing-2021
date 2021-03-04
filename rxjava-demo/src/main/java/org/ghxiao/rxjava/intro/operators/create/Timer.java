package org.ghxiao.rxjava.intro.operators.create;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Timer {
    public static void main(String[] args) throws InterruptedException {
        Observable
                .timer(5, TimeUnit.SECONDS)
                .subscribe(
                        System.out::println,
                        System.out::println,
                        () -> System.out.println("Done")
                );

        Thread.sleep(10000);
    }
}
