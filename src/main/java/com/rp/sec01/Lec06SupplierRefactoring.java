package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {

        //only subscription would call the execution.
        getName();
        //getName().subscribe(Util.onNext());
        // ideally it waits for to pull up name making it await.

        getName().subscribeOn(Schedulers.boundedElastic()).subscribe(Util.onNext());
        getName();

        Util.sleepSeconds(4);



    }


    private static Mono<String> getName(){
        System.out.println("Entered getName method");

        // building the pipeline is easy rather than execution.
        return Mono.fromSupplier(() -> {
            System.out.println("Genearting name..");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();

        }).map(String::toUpperCase);
    }
}
