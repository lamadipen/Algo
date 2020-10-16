package kata.thread.threadExample;

public class RunnableThreadExample implements Runnable {
    int count = 0;

    @Override
    public void run() {
        System.out.println("Runnable thread starting");

        try {
            while (count < 5) {
                Thread.sleep(500);
                System.out.println("Runnable thread incrementing count");
                count++;
            }
        } catch (InterruptedException e) {
            System.err.println("Runnable Thread Interrupted");
        }
        System.out.println("Runnable Thread Terminated");
    }

    public static void main(String[] args) {
        RunnableThreadExample runnableThreadExample = new RunnableThreadExample();
        Thread thread = new Thread(runnableThreadExample);
        thread.start();

        //if below wait is not implemented main thread is called instantly
        // System.out.println("Back to main thread");

        //waits until above thread counts to 5 slowly
        try {
            while (runnableThreadExample.count != 5) {
                Thread.sleep(500);
                System.out.println("Back to main thread");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
