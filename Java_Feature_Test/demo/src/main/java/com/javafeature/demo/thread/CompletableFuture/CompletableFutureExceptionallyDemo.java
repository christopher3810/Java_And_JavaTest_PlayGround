package com.javafeature.demo.thread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;

//java 8

@Slf4j
public class CompletableFutureExceptionallyDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        boolean throwError = true;

        CompletableFuture<String> lionFuture = CompletableFuture.supplyAsync(() -> {

            if (throwError){
                throw new IllegalArgumentException();
            }

            log.info("lion" + Thread.currentThread().getName());
            return "retured lion";
        }).exceptionally(ex -> {
            return "Error!"; //function return 가능
        });

        log.info(lionFuture.get());

        CompletableFuture<String> tigerFuture = CompletableFuture.supplyAsync(() -> {

            if (throwError){
                throw new IllegalArgumentException();
            }

            log.info("tiger" + Thread.currentThread().getName());
            return "retured lion";
        }).handle((result, ex) -> { //byfunction이 들어있음. result가 들어오면 result return
            if(ex != null){
                log.info(String.valueOf(ex));
                return "Error!";
            }
            return result;
        });

        log.info(tigerFuture.get());
    }



}
