package org.ghxiao.rxjava.intro;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;

import java.time.LocalDateTime;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class RxBackpressueDemo {
    public static void main(String[] args) {
        Flowable.create(RxBackpressueDemo::emit, BackpressureStrategy.DROP)
                .subscribe(
                        System.out::println,
                        e -> System.out.println("Boom!!" + e),
                        () -> System.out.println("Done")
                );

        sleep(10_000);
    }

    private static void emit(FlowableEmitter<Integer> emitter) {
        int count = 0;
        while (count < 10) {
            count++;
            System.out.println("time " + LocalDateTime.now() + " thread: " + Thread.currentThread().getName() + " Emitting..." + count);
            emitter.onNext(count); // <-
            if (count == 5) {
                emitter.onError(new RuntimeException("bang!"));
            }
            sleep(500);
        }
        emitter.onComplete();
    }


    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}