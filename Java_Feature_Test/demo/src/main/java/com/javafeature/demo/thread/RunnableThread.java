package com.javafeature.demo.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableThread implements Runnable {

    public static void main(String... runnableThread) {
        log.info(Thread.currentThread().getName());

        new Thread(new RunnableThread()).start();
    }

    @Override
    public void run() {
        log.info(Thread.currentThread().getName());
    }
}
