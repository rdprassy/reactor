package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main (String args[]){


        Mono<Integer> mono = Mono. just("ball")
                .map(String::length)
                .map(l->l/0);

        // one way of doing things
        mono.subscribe();

        //other way
        mono.subscribe(item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );

        //
    }
}
