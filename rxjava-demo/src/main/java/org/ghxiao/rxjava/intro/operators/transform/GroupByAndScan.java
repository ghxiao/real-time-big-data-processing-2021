package org.ghxiao.rxjava.intro.operators.transform;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

import java.util.concurrent.TimeUnit;

public class GroupByAndScan {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS).groupBy(i -> i % 3)
                .subscribe(
                        (GroupedObservable<Long, Long> go) -> {
                            go.scan((x, y) -> x + y)
                                    .subscribe((Long v) -> System.out.println("key: " + go.getKey()
                                            + " value: " + v));
                        });
        Thread.sleep(10000);
    }
}
