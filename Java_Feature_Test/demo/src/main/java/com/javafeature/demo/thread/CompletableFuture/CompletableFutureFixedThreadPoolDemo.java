package com.javafeature.demo.thread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

//java 8

@Slf4j
public class CompletableFutureFixedThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> voidFuture = CompletableFuture.supplyAsync(() -> {
            log.info("hi" + Thread.currentThread().getName());
            return "retured hi";
        }, executorService).thenRunAsync(() -> {
            log.info(Thread.currentThread().getName());
        }, executorService);

        voidFuture.get();

        executorService.shutdown();
        //forkjoin pool의 common thread를 활용하지 않음.
    }
}
