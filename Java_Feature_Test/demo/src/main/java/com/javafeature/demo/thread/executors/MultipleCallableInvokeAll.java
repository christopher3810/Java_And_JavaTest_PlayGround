package com.javafeature.demo.thread.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultipleCallableInvokeAll {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hi = () -> {
            Thread.sleep(2000L);
            return "hi";
        };

        Callable<String> lion = () -> {
            Thread.sleep(3000L);
            return "lion";
        };

        Callable<String> tiger = () -> {
            Thread.sleep(1000L);
            return "tiger";
        };

        List<Callable<String>> tasks = Arrays.asList(hi, lion, tiger);
        List<Future<String>> futures = executorService.invokeAll(tasks);

        futures.stream().map(future -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                log.error("An error occurred while waiting for a task to complete", e);
                return null;
            }
        }).forEach(log::info);

        executorService.shutdown();
    }
}
