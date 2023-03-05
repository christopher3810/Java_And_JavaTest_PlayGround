package com.javafeature.demo.thread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompletableFutureAsyncThenApplyDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> returnedFuture = CompletableFuture.supplyAsync(() -> {
//            log.info("hi" + Thread.currentThread().getName());
//            return "retured hi";
//        }).thenApply((s) ->{
//            log.info(Thread.currentThread().getName());
//            return s.toUpperCase();
//        });
//        returnedFuture.get();

        //future만 사용했을 때에는 callback을 get 호출하기전에 정의하는게 불가능햇는데 이제는 가능하다.

//        CompletableFuture<Void> voidFuture = CompletableFuture.supplyAsync(() -> {
//            log.info("hi" + Thread.currentThread().getName());
//            return "retured hi";
//        }).thenAccept((s) -> {
//            log.info(Thread.currentThread().getName());
//            log.info(s.toUpperCase());
//        });
//
//        voidFuture.get();
        //return이 없는 경우 thenAccept를 사용하면 됨.
        //return이 없기 때문에 type이 달라짐.

        CompletableFuture<Void> voidFuture = CompletableFuture.supplyAsync(() -> {
            log.info("hi" + Thread.currentThread().getName());
            return "retured hi";
        }).thenRun(() -> {
            log.info(Thread.currentThread().getName());
        });

        voidFuture.get();

        //callback으로 return을 받을 필요가 없다 그냥 무엇을 하기만 하면 된다
        //Runable이 옴 아무것도 못함.
        //thread를 별도로 만들지 않고 이렇게 비동기로 따로따로 처리가 가능한것인가?
        //forkjoinpool을 통해서 가능함.
        //dqueue를 사용함
        //맨마지막에 들어온것이 먼저나감,
        //자기 스레드가 할일이 없으면 dqueue에서 가져와서 실행하는 로직.
        //sub task를 스레드에 처리시키고 join 모아서 결과값을 도출 시킴.
        //별다른 Executor를 사용하지 않아도 forkjoin의 common pool을 활용합니다.

    }
}
