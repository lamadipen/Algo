package com.effectivejava.concurrency.preferconcurrencyutilities;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentTime {
    private ConcurrentTime() {
    }//Noninstantiable

    public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown(); //Tell timer we're ready
                try {
                    start.await(); //Wait till the peers are ready
                    action.run();
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }finally {
                    done.countDown(); //Tell timer we're done
                }
            });
        }

        ready.await();
        long startNanos = System.nanoTime();
        start.countDown();
        done.await();
        return System.nanoTime() - startNanos;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //Number of concurrency and number of thread in Pool should match
        //if the number of thread is less than concurrency it will cause thread starving deadlock
        long runnable = time(executorService, 3, () -> System.out.println("Runnable"));
        System.out.println(runnable);

    }
}
