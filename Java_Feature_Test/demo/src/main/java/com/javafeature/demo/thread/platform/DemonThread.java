package com.javafeature.demo.thread.platform;

import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemonThread {
    public static void main(String... nonDaemonAndDaemon) throws InterruptedException {
        log.info("Starting the execution in the Thread " + Thread.currentThread().getName());

        Thread daemonThread = new Thread(() -> IntStream.rangeClosed(1, 100000)
            .forEach(i -> log.info(Integer.toString(i))));

        daemonThread.setDaemon(true);
        daemonThread.start();

        Thread.sleep(10);

        log.info("End of the execution in the Thread " +
            Thread.currentThread().getName());
    }
}
