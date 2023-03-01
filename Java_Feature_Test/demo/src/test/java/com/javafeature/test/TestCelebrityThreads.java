package com.javafeature.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCelebrityThreads {


    private static final Logger log = LoggerFactory.getLogger(TestCelebrityThreads.class);

    private static int testline = 10;

    @Test
    public void testCelebrityThreads() throws InterruptedException {
        new Celebrity("Tom Cruise").start();

        Celebrity famousActor = new Celebrity("Dwayne Johnson");
        famousActor.setPriority(Thread.MAX_PRIORITY);
        famousActor.setDaemon(false);
        famousActor.start();

        Celebrity famousSinger = new Celebrity("Adele");
        famousSinger.setPriority(Thread.MIN_PRIORITY);
        famousSinger.start();

        Thread.sleep(1000);

        log.info("Wolverine adrenaline: {}", testline );
    }

    static class Celebrity extends Thread {
        Celebrity(String name) { super(name); }

        @Override
        public void run() {
            testline ++;
            if (testline  == 13) {
                log.info(this.getName());
                }
            }
        }
}

