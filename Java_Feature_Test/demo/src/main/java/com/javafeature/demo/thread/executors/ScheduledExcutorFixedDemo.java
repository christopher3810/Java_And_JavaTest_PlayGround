package com.javafeature.demo.thread.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScheduledExcutorFixedDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.scheduleWithFixedDelay(() -> log.info("hi" + Thread.currentThread().getName()), 1, 5, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(() -> log.info("hi" + Thread.currentThread().getName()), 1, 5, TimeUnit.SECONDS);
        try {
            Thread.sleep(10000); // sleep for 10 seconds to allow the task to run
        } catch (InterruptedException e) {
            log.error("Interrupted while sleeping", e);
        }
        executorService.shutdown();
    }
}