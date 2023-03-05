package com.javafeature.demo.thread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompletableFutureAsyncDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidFuture = CompletableFuture.runAsync(() -> {
            log.info("hi" + Thread.currentThread().getName());
        }); //리턴타입이 없는 경우

        //voidFuture.get();

        CompletableFuture<String> returnedFuture = CompletableFuture.supplyAsync(() -> {
            log.info("hi" + Thread.currentThread().getName());
            return "retured hi";
        });

        //결과가 왔을때 async하게 callback을 실행할 했으면 좋겠다. 하지만 get은 처리할 수 있음.

        log.info(returnedFuture.get());
    }

}
