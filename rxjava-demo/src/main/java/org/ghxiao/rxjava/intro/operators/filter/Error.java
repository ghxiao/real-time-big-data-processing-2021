package org.ghxiao.rxjava.intro.operators.filter;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Error {
    public static void main(String[] args) throws InterruptedException {
        final Observable<Long> backup
                = Observable.interval(1, TimeUnit.SECONDS);
        Observable.create(emitter -> {
            emitter.onNext(1L);
            emitter.onNext(2L);
            emitter.onError(new RuntimeException("error!"));
            emitter.onComplete();
        })
//.onErrorReturnItem(0L)
                .onErrorResumeNext(backup) 
                .subscribe(
                        System.out::println,
                        System.out::println
                );
        Thread.sleep(20000);
    }
}
