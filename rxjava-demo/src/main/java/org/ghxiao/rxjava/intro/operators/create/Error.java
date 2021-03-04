package org.ghxiao.rxjava.intro.operators.create;

import io.reactivex.Observable;

public class Error {
    public static void main(String[] args) throws InterruptedException {
        Observable
                .error(new RuntimeException("boom!"))
                .subscribe(
                        System.out::println,
                        System.out::println,
                        () -> System.out.println("Done")
                );
        
        Thread.sleep(10000);
    }
}
