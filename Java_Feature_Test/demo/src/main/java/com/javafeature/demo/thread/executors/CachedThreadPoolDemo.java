package com.javafeature.demo.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;


public class CachedThreadPoolDemo {

    public static void main(String[] args) {
        // cached thread pool 생성
        ExecutorService executor = Executors.newCachedThreadPool();

        // int stream 으로 task 할당 할당 된 만큼 thread 생성
        IntStream.range(0, 10)
            .forEach(i -> executor.execute(new DemoTask(i)));

        // Shutdown the thread pool when all tasks are completed
        executor.shutdown();
    }
}
@Slf4j
class DemoTask implements Runnable {
    private int taskId;

    public DemoTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
       log.info("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
    }
}
