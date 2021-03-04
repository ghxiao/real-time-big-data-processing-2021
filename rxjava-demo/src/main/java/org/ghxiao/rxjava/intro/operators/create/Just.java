package org.ghxiao.rxjava.intro.operators.create;

import io.reactivex.Observable;

public class Just {
    public static void main(String[] args) throws InterruptedException {
        Observable
                .just(1)
                .subscribe(
                        System.out::println,
                        System.out::println,
                        () -> System.out.println("Done")
                );

        Thread.sleep(10000);
    }
}
