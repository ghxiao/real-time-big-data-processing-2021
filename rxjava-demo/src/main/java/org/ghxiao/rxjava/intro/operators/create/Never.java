package org.ghxiao.rxjava.intro.operators.create;

import io.reactivex.Observable;

public class Never {
    public static void main(String[] args) throws InterruptedException {
        Observable
                .never()
                .subscribe(
                        System.out::println,
                        System.out::println,
                        () -> System.out.println("Done")
                );
        
        Thread.sleep(10000);
    }
}
