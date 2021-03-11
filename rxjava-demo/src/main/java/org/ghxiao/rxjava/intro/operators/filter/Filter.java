package org.ghxiao.rxjava.intro.operators.filter;

import io.reactivex.Observable;

public class Filter {
    public static void main(String[] args) {
        Observable.fromArray(1, 4, 2, 3, 4, 3, 2, 1)
                .filter(x -> x % 2 == 0)                .subscribe(
                        System.out::println,
                        err -> System.out.println("ERROR " + err), 
                        () -> System.out.println("DONE"));
    }
}
