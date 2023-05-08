package com.javafeature.demo.CustomAutoCloseable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedCounter {
    private final Lock lock = new ReentrantLock();
    private int counter = 0;

    public void incrementCounter() {
        try (AutoCloseableLock autoLock = new AutoCloseableLock(lock)) {
            counter++;
            System.out.println("Counter value: " + counter);
        } // AutoCloseableLock의 close() 메서드가 자동으로 호출되어 잠금이 해제됩니다.
    }

    public int getCounter() {
        return counter;
    }
}

