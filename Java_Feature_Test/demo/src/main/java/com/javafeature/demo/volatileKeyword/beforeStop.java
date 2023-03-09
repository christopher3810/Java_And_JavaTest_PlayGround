package com.javafeature.demo.volatileKeyword;

public class beforeStop {

    private static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while(!stop) {}
            System.out.println("Thread stopped");
        }).start();

        Thread.sleep(1000);
        stop = true;
    }

}
