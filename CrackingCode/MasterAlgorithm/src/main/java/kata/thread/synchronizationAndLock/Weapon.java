package kata.thread.synchronizationAndLock;

public class Weapon {

    public synchronized void fire(String name) {
        try {
            System.out.println("Thread [" + name + "] starting");
            Thread.sleep(3000);
            System.out.println("Thread [" + name + "] ending");
        } catch (InterruptedException e) {
            System.err.println("Thread [" + name + "] interrupted");
        }
    }
}
