package org.ghxiao.rxjava.intro.operators.aggregate;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Average {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(4)
                .reduce(
                        new Aggregator(0, 0),
                        (a, i) -> new Aggregator(a.sum + i, a.count + 1)
                )
                .map(a -> (float)a.sum / (float)a.count)
                .subscribe(
                        System.out::println,
                        err -> System.out.println("ERROR " + err)
                );
        Thread.sleep(6000);
    }

    public static class Aggregator {
        final long sum, count;

        public Aggregator(long sum, long count) {
            this.sum = sum;
            this.count = count;
        }
    }
}
