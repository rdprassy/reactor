package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {
//        Runnable runnable = ()->
//            System.out.println("");


        // invoke runnable after the above operation is complete
        Mono.fromRunnable(timeConsumingProcess()).subscribe(Util.onNext(),
                Util.onError(), () ->{
                    System.out.println("process is done. Sending emails....");
                });


        // at times when a operation is a time consuming and you want to be notified.

    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
