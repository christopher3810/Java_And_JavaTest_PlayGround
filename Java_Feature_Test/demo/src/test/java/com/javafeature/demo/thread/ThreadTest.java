package com.javafeature.demo.thread;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThreadTest {

    private static int wolverineAdrenaline = 10;

    @Test
    void testMotorcycles() throws InterruptedException {
        Thread harleyDavidson = new Thread(new Motorcycle("Harley Davidson"));
        Thread dodgeTomahawk = new Thread(new Motorcycle("Dodge Tomahawk"));
        Thread yamahaYZF = new Thread(new Motorcycle("Yamaha YZF"));

        dodgeTomahawk.setPriority(Thread.MAX_PRIORITY);
        yamahaYZF.setPriority(Thread.MIN_PRIORITY);

        harleyDavidson.start();
        dodgeTomahawk.start();
        yamahaYZF.start();

        Thread.sleep(100); // Wait for threads to finish

        // Assert that wolverineAdrenaline is 13
        assert wolverineAdrenaline == 13;
    }

    static class Motorcycle implements Runnable {
        private String bikeName;

        Motorcycle(String bikeName) { this.bikeName = bikeName; }

        @Override
        public void run() {
            wolverineAdrenaline++;
        }
    }
}