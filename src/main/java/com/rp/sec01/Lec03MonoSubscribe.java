package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main (String args[]){


        Mono<Integer> mono = Mono. just("ball")
                .map(String::length)
                .map(l->l/1);

        // one way of doing things
        mono.subscribe();

        //other way
        mono.subscribe(item -> Util.onNext(),
                Util.onError(),
                Util.onComplete()

        );

        //
    }
}
