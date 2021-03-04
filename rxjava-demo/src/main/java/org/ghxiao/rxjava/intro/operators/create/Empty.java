package org.ghxiao.rxjava.intro.operators.create;

import io.reactivex.Observable;

public class Empty {
    public static void main(String[] args) {
        Observable
                .empty()
                .subscribe(
                        System.out::println,
                        System.out::println,
                        () -> System.out.println("Done")
                );
    }
}
