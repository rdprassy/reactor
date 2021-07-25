package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {
    public static void main(String[] args) {

        //make it as a publisher
        Mono.fromFuture(getName())
                .subscribe(Util.onNext());

        Util.sleepSeconds(1);

    }




    private static CompletableFuture<String> getName(){
    // runs aysn way
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}
