package com.javafeature.demo.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorsDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            log.info("Thread" + Thread.currentThread().getContextClassLoader());
        });
        //작업 실행후 다음 작업이 들어오기 전까지 대기하기 때문에 명시적으로 sutdown을 시켜야됨

        executorService.shutdown();
        //gracefull shutdown
    }

}
