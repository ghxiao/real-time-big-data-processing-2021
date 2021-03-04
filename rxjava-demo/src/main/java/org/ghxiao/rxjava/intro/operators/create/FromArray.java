package org.ghxiao.rxjava.intro.operators.create;

import io.reactivex.Observable;

public class FromArray {
    public static void main(String[] args) throws InterruptedException {
        Observable
                .fromArray(1, 2, 3)
                .subscribe(
                        System.out::println,
                        System.out::println,
                        () -> System.out.println("Done")
                );

        Thread.sleep(10000);
    }
}
