package kata.thread.threadExample;

public class ThreadExampleInvoker {
    public static void main(String[] args) {
        ThreadExample threadExample = new ThreadExample();
        threadExample.start();

        //if below wait is not implemented main thread is called instantly
        // System.out.println("Back to main thread");

        //waits until above thread counts to 5 slowly
        try {
            while (threadExample.count != 5) {
                Thread.sleep(500);
                System.out.println("Back to main thread");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
