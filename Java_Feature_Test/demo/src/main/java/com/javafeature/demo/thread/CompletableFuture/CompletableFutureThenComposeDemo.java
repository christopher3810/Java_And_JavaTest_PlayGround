package com.javafeature.demo.thread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompletableFutureThenComposeDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> lionFuture = CompletableFuture.supplyAsync(() -> {
            log.info("lion" + Thread.currentThread().getName());
            return "retured lion";
        });



        //lion 끝난뒤에 tiger를 해야하는 경우 lion get 이후 tiger get을 해야 했음.
//        lionFuture.get();
//        tigerFuture.get();
        CompletableFuture<String> stringCompletableFuture = lionFuture.thenCompose(
            CompletableFutureThenComposeDemo::getwordFuture);
        log.info(stringCompletableFuture.get());
        //하지만 이런경우에는 두가지 future가 연관관계가 존재하는 경우임.
        // 연관 관계가 없는 경우 하지만 둘이 동시에 비동기로 움직이는 경우.

        CompletableFuture<String> samsungFuture = CompletableFuture.supplyAsync(() -> {
            log.info("samsung" + Thread.currentThread().getName());
            return "retured samsung";
        });

        CompletableFuture<String> appleFuture = CompletableFuture.supplyAsync(() -> {
            log.info("apple" + Thread.currentThread().getName());
            return "retured apple";
        });

        CompletableFuture<String> samsungAppleCombineFuture = samsungFuture.thenCombine(appleFuture,
            (s, a) -> s + " " + a);
        log.info(samsungAppleCombineFuture.get());

    }

    private static CompletableFuture<String> getwordFuture(String s) {
        return CompletableFuture.supplyAsync(() -> {
            log.info(s + Thread.currentThread().getName());
            return "retured " + s;
        });
    }

}
