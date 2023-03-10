package com.javafeature.demo.thread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;

//java 8

@Slf4j
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> futureResult = new CompletableFuture<String>();
//        futureResult.complete("lion"); //명시적으로 값을줘서 complete 시킬 수 있음.
        CompletableFuture<String> futured = CompletableFuture.completedFuture("lion");

        log.info(futured.get());

    }

}
