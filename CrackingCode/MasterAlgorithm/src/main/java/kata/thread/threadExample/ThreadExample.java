package kata.thread.threadExample;

public class ThreadExample extends Thread {
    int count = 0;

    @Override
    public void run() {
        System.out.println("Thread is starting");

        try {
            while (count < 5) {
                Thread.sleep(500);
                System.out.println("Thread incrementing count");
                count++;
            }
        } catch (InterruptedException e) {
            System.err.println("Thread Interrupted");
        }
        System.out.println("Thread Terminated");
    }
}
