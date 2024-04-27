package com.javafeature.demo.volatileKeyword;

public class vtask implements Runnable{
    private volatile boolean stop = false;

    public void run() {
        while (!stop) {
            // do some work
        }
    }

    public void stop() {
        stop = true;
    }
}
