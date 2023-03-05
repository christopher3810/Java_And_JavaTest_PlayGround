package com.javafeature.demo.thread.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CallableAndFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> futuresubmit = executorService.submit(hello);
        log.info(String.valueOf(futuresubmit.isDone()));
        log.info("started");

        futuresubmit.cancel(true); //interupt하고 종료
        //futuresubmit.cancel(false); //false를 한들 일단 리턴값을 가져 올 수 없음

        log.info(String.valueOf(futuresubmit.isDone())); //cancle을 호출한 이상 true가 됨

        log.info("End!");
        executorService.shutdown();
    }


}
