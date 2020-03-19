package com.effectivejava.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Effective Java
 * Chapter 11 CONCURRENCY
 * Synchronize access to shared mutable data
 *
 * Synchronization is required for reliable communication between threads as well as for mutual exclusion.
 * The consequences of failing to synchronize access to shared mutable data can be dire even if the data is
 * automatically readable and writable.
 *
 * A recommended way to stop one thread from another is to have the first thread poll a boolean field that is
 * initially false but can set to true by the second thread to indicate that the first thread is to stop itself.
 * Because reading and writing a boolean field is atomic.
 *
 * Problem
 * The program never terminates
 *
 * */
//Properly synchronized cooperative thread termination
public class StopThreadSolution2 {
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
