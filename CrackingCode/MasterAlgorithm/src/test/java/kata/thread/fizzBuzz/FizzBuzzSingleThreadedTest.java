package kata.thread.fizzBuzz;

import org.junit.Test;

public class FizzBuzzSingleThreadedTest {

    @Test
    public void fizzBuzz() {
        FizzBuzzSingleThreaded singleThreaded = new FizzBuzzSingleThreaded();
        singleThreaded.print(6);
    }

    @Test
    public void fizzBuzzWithMultiThread() {
        FizzBuzzSingleThreaded singleThreaded = new FizzBuzzSingleThreaded();

        Thread t1 = new Thread(() -> singleThreaded.print(6));
        Thread t2 = new Thread(() -> singleThreaded.print(6));
        Thread t3 = new Thread(() -> singleThreaded.print(6));
        Thread t4 = new Thread(() -> singleThreaded.print(6));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}