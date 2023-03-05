package com.javafeature.demo.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScheduledExcutorDemo {
    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.scheduleAtFixedRate(getRunnable("hi"), 1, 2,  TimeUnit.SECONDS);

        //        executorService.schedule(getRunnable("hi"), 3,  TimeUnit.SECONDS);
        //3초뒤 실행


        //쓰레드 두가지를 번갈하가면서 실행을 함.
        executorService.shutdown();
    }

    private static Runnable getRunnable(String message){
        return () -> log.info(message + Thread.currentThread().getName());
    }

}
