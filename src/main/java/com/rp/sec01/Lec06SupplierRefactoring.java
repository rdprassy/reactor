package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {

        //only subscription would call the execution.
        getName();
        getName();
        getName().subscribe(Util.onNext());


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
