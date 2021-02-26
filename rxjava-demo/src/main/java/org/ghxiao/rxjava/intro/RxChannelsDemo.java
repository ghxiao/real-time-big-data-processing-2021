package org.ghxiao.rxjava.intro;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalDateTime;

public class RxChannelsDemo {

    public static void main(String[] args) {
        Flowable.create(RxChannelsDemo::emit, BackpressureStrategy.DROP)
                .observeOn(Schedulers.computation(), true,2) // <-- async, non-blocking
                //.observeOn(Schedulers.io(), true,2) // <-- blocking
                .map(data -> data * 1)
                .subscribe(
                        RxChannelsDemo::process,
                        err -> System.out.println("ERROR " + err),
                        () -> System.out.println("DONE"));
        sleep(10_000);
    }

    private static void emit(FlowableEmitter<Integer> emitter) {
        int count = 0;

        while (count < 5) {
            count++;
            System.out.println("time " + LocalDateTime.now() + " thread: " + Thread.currentThread().getName() + " Emitting..." + count);
            emitter.onNext(count);

//            if (count == 5) {
//                emitter.onError(new RuntimeException("bang!"));
//            }
            sleep(500);
        }

        emitter.onComplete();
    }

    public static long process(long n){
        System.out.println("time " + LocalDateTime.now() + " thread: " + Thread.currentThread().getName() + " processing " + n);
//        if(n == 4) {
//            throw new RuntimeException("Something went wrong!" + n);
//        }
        sleep(1000);
        return n * 2;
    }


    private static boolean sleep(int ms) {
        try {
            Thread.sleep(ms);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
}
