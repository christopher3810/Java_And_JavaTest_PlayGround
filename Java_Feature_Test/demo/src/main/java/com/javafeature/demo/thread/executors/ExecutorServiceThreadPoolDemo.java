package com.javafeature.demo.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorServiceThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnable("Hello"));
        executorService.submit(getRunnable("lion"));
        executorService.submit(getRunnable("tiger"));
        executorService.submit(getRunnable("shark"));


        //쓰레드 두가지를 번갈하가면서 실행을 함.
        executorService.shutdown();
    }

    private static Runnable getRunnable(String message){
        return () -> log.info(message + Thread.currentThread().getName());
    }

}
