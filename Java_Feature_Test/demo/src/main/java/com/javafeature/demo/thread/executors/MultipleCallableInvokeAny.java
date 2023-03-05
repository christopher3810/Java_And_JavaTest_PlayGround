package com.javafeature.demo.thread.executors;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultipleCallableInvokeAny {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

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

        String result = executorService.invokeAny(Arrays.asList(hi, lion, tiger));
        log.info(result);

        //각각의 task가 끝나기를 기다렸다가 로직 처리를 해야되는 경우도 존재하지만.
        // server 3군데에서 sever에서 replication된 copy3가지를 전부 가져와야 한다면?
        // server 별 레이턴시가 다르다면 가장 빠르게 온놈만 챙겨서 return 하면됨.
        // 하지만 싱글 스레드라 스레드의 처리 결과는 예측이 안됨

        executorService.shutdown();
    }
}