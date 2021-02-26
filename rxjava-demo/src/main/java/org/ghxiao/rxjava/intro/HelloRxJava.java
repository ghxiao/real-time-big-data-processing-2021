package org.ghxiao.rxjava.intro;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class HelloRxJava {
    public static void main(String[] args) {
        Flowable.interval(1, 1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        sleep(10_000);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
