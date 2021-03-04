package org.ghxiao.rxjava.intro.operators.create;

import io.reactivex.Observable;

public class Create {
    public static void main(String[] args) {
        Observable
                .create(
                        emitter -> {
                            emitter.onNext(1);
                            emitter.onNext(2);
                            emitter.onError(new RuntimeException("boom!"));
                            emitter.onComplete();
                        }
                )
                .subscribe(
                        System.out::println,
                        System.out::println,
                        () -> System.out.println("Done")
                );
    }
}
