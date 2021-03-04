package org.ghxiao.rxjava.intro.operators.transform;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class GroupBy {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .groupBy(i -> i % 3)
                .subscribe(
                        go ->
                                go.subscribe(
                                        el -> System.out.println("key: " + go.getKey()
                                                + " value: " + el)
                                )
                );

        Thread.sleep(20_000);
    }
}
