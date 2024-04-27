package com.javafeature.demo.volatileKeyword;

import java.util.concurrent.CountDownLatch;

public class TaskRunner {
    private static volatile int number;
    private static volatile boolean ready;
    private static CountDownLatch latch = new CountDownLatch(1);

    private static class Reader extends Thread {

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Reader().start();
        number = 42;
        ready = true;
        latch.countDown();
    }
}
