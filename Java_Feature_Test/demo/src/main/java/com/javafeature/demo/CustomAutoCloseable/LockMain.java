package com.javafeature.demo.CustomAutoCloseable;

public class LockMain {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

        // 스레드 10개를 생성하고 실행하여 카운터 값을 증가시킵니다.
        for (int i = 0; i < 10; i++) {
            new Thread(() -> sharedCounter.incrementCounter()).start();
        }
    }
}
