package kata.thread.fizzBuzz;

public class FizzBuzzRunner {

    public static void main(String[] args) {
        Thread[] threads = new Thread[]{
                new FizzBuzzThread(15, true, true, "fizzbuzz"),
                new FizzBuzzThread(15, true, false, "fizz"),
                new FizzBuzzThread(15, false, true, "buzz"),
                new NumberThread(15, false, false, "buzz"),
        };

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
