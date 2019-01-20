package com.dp.cci.parallelthread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/*
 * https://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
 * https://www.concretepage.com/java/jdk-8/java-8-runnable-and-callable-lambda-example-with-argument
 * */
public class CommonForkJoinPoolExample {



    @Test
    public void threadPracticeTest() {
        Runnable r1 = () -> {
            System.out.println("Thread R1 running" + Thread.currentThread().getName());
        };

        Runnable r2 = () -> {
            System.out.println("Thread R2 running" + Thread.currentThread().getName());
        };

        //Old way of running thread
        // Using without concurrency API, creating thread manually
        // which is error pron and tedious to maintain
        //Thread t1 = new Thread(r1);
        //Thread t2 = new Thread(r2);

        //t1.start();
        //t2.start();

        //Present way of running thread
        // Using Executor from concurrent API as a higher level
        // replacement for working with threads directly
        // Executors are capable of running asynchronous tasks and
        // typically manage a pool of threads, so we don't have to
        // create new threads manually. All threads of the internal pool
        // will be reused under the hood for revenant tasks, so we can run
        // as many concurrent tasks as we want throughout the life-cycle of
        // our application with a single executor service.
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(r1);
        executor.submit(r2);
        executor.shutdown();
        try {
            System.out.println("attempt to shutdown executor");
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }

        //Callables and Futures
        //Callables are functional interfaces just like runnables
        // but instead of being void they return a value
        Callable<String> callable1 = () -> {
            return "My Thread 1";
        };

        Callable<String> callable2 = () -> {
            return "My Thread 2";
        };

        ExecutorService executor2 = Executors.newFixedThreadPool(2);

        Future<String> future1 = executor2.submit(callable1);
        Future<String> future2 = executor2.submit(callable2);

        try {
            System.out.println(future1.get());
            future2.isDone();
            System.out.println(future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void mvccTest() {
        Runnable r1 = () -> {
            System.out.println("Thread R1 running" + Thread.currentThread().getName());
        };

        Runnable r2 = () -> {
            System.out.println("Thread R2 running" + Thread.currentThread().getName());
        };
    }

    @Test
    public void givenList_whenCallingParallelStream_shouldBeParallelStream(){
        List<Long> aList = new ArrayList<>();
        Stream<Long> parallelStream = aList.parallelStream();

        assertTrue(parallelStream.isParallel());
    }

    @Test
    public void giveRangeOfLongs_whenSummedInParallel_shouldBeEqualToExpectedTotal()
            throws InterruptedException, ExecutionException {

        long firstNum = 1;
        long lastNum = 1_000_000;

        List<Long> aList = LongStream.rangeClosed(firstNum, lastNum).boxed()
                .collect(Collectors.toList());

        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        long actualTotal = customThreadPool.submit(
                () -> aList.parallelStream().reduce(0L, Long::sum)).get();

        assertEquals((lastNum + firstNum) * lastNum / 2, actualTotal);
    }



    //in general, IO tasks can be parallelized more than a pure computing task.
    //However, you must be aware of overusing it. If you over-commit, the system
    // could fight for resources that are not there!
    //https://www.codementor.io/nitinpuri/controlling-parallelism-of-java-8-collection-streams-umex0qbt1
    final int PARALLELISM_LEVEL = 10;
    ForkJoinPool forkJoinPool = null;

    @Test
    public void runParallelToMakeIoCall() throws ExecutionException, InterruptedException {
        List<String> feedUrls = new ArrayList<>();
        forkJoinPool = new ForkJoinPool(PARALLELISM_LEVEL);

        forkJoinPool.submit(()->
                feedUrls.parallelStream()
                        .map( (s) -> "I am " + s )
                        .collect(Collectors.toList())
        ).get(); //this makes it overall blocking call
        forkJoinPool.shutdown();
    }

    private static List<Integer> getNumbers(int max){

        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i < max; i ++)
            numbers.add(i);

        return Collections.unmodifiableList(numbers);
    }

    @Test
    public void commonForkJoinPoolParallelTest(){
        List<Integer> numbers = getNumbers(100);

        numbers.parallelStream()
                .forEach( n -> {
                    try {
                        Thread.sleep(5);
                        System.out.println("Loop 1 : " + Thread.currentThread());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    @Test
    public void commonForkJoinPoolWithTwoParallelTest() throws InterruptedException {
        List<Integer> numbers = getNumbers(100);

        Thread thread1 = new Thread(() -> {
            numbers.parallelStream()
                    .forEach( n -> {
                        try {
                            Thread.sleep(5);
                            System.out.println("Loop 1 : " + Thread.currentThread());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
        });

        Thread thread2 = new Thread(() -> {
            numbers.parallelStream()
                    .forEach( n -> {
                        try {
                            Thread.sleep(5);
                            System.out.println("Loop 2 : " + Thread.currentThread());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    @Test
    public void commonForkJoinPoolWithTwoParallelThreadInSepratePoolTest() throws InterruptedException {
        List<Integer> numbers = getNumbers(100);
        ForkJoinPool forkJoinPool1 = new ForkJoinPool(4);

        Thread thread1 = new Thread(() -> {
            numbers.parallelStream()
                    .forEach( n -> {
                        try {
                            Thread.sleep(5);
                            System.out.println("Loop 1 : " + Thread.currentThread());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
        });

        ForkJoinPool forkJoinPool2 = new ForkJoinPool(4);
        Thread thread2 = new Thread(() -> {
            numbers.parallelStream()
                    .forEach( n -> {
                        try {
                            Thread.sleep(5);
                            System.out.println("Loop 2 : " + Thread.currentThread());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
        });

       forkJoinPool1.submit(thread1).invoke();
       forkJoinPool2.submit(thread2).invoke();
    }


}
