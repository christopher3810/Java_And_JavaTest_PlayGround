package com.javafeature.demo.thread;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ThreadPriority {

    public static void main(String... threadPriority) {
        Thread lionThread = new Thread(() -> log.info("lion"));
        Thread tigerThread = new Thread(() -> log.info("tiger"));
        Thread dragonThread = new Thread(() -> log.info("dragon"));

        lionThread.setPriority(Thread.MIN_PRIORITY);
        tigerThread.setPriority(Thread.NORM_PRIORITY);
        dragonThread.setPriority(Thread.MAX_PRIORITY);

        lionThread.start();
        tigerThread.start();
        dragonThread.start();
    }
}





