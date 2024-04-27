package com.javafeature.demo.volatileKeyword;

public class testSingleton {
    private static volatile testSingleton instance;

    private testSingleton() {}

    public static testSingleton getInstance() {
        if (instance == null) {
            synchronized (testSingleton.class) {
                if (instance == null) {
                    instance = new testSingleton();
                }
            }
        }
        return instance;
    }
}
