package org.ghxiao.rxjava.intro;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;

public class RxObserverDemo {

    public static void main(String[] args) {
        Flowable.create(RxObserverDemo::emit, BackpressureStrategy.DROP)
                .observeOn(Schedulers.computation(), true,2) // <-- async, non-blocking
                //.observeOn(Schedulers.io(), true,2) // <-- blocking
                .map(data -> data * 1)
                .subscribe(new MySubscriber());
        sleep(10_000);
    }

    public static class MySubscriber implements Subscriber<Integer> {


        @Override
        public void onSubscribe(Subscription s) {
            
        }

        @Override
        public void onNext(@NonNull Integer s) {
            process(s);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            System.out.println("ERROR " + e);
        }

        @Override
        public void onComplete() {
            System.out.println("DONE");
        }
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
