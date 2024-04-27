package com.javafeature.demo.thread.platform;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainThread {

    public static void main(String... mainThread) {
        log.info(Thread.currentThread().getName());
    }

}
