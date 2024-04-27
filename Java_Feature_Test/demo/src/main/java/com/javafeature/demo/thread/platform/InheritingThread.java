package com.javafeature.demo.thread.platform;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InheritingThread extends Thread{
    InheritingThread(String threadName) {
        super(threadName);
    }

    public static void main(String... inheriting) {
        log.info(Thread.currentThread().getName() + " is running");

        new InheritingThread("inheritingThread").start();
    }

    @Override
    public void run() {
        log.info(Thread.currentThread().getName() + " is running");
    }
}
