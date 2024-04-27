package com.javafeature.demo.thread.virtual;

import java.util.List;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VirtualThread {

    public static void main(String[] args) {
        platformThreadRun();
        virtualThreadRun();
    }

    //1sec, 222ms
    private static void virtualThreadRun() {
        List<Thread> threads = IntStream.range(0, 1_000_000)
            .mapToObj(i -> Thread.ofVirtual().unstarted(() -> {})) //do nothing
            .toList();

        threads.forEach(Thread::start);
    }

    //31sec
    private static void platformThreadRun() {
        List<Thread> threads = IntStream.range(0, 1_000_000)
            .mapToObj(i -> new Thread(() -> {})) //do nothing
            .toList();

        threads.forEach(Thread::start);
    }


}
