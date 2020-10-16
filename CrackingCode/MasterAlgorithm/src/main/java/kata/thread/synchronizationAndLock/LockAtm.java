package kata.thread.synchronizationAndLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * You can comment the lock and unlock code block and run program multiple time to see the discrepancy on the calculation
 */
public class LockAtm {
    Lock atmLock;
    private int balance = 100;

    public LockAtm() {
        this.atmLock = new ReentrantLock();
    }

    public int withDraw(int amt) {
        atmLock.lock();
        int temp = balance;

        try {
            Thread.sleep(100);
            temp = temp - amt;
            Thread.sleep(100);
            balance = temp;
            System.out.println("Total balance after withdraw " + balance);
        } catch (InterruptedException e) {
            System.err.println("Exception while withdrawing");
        }
        atmLock.unlock();
        return temp;
    }

    public int deposit(int amt) {
        atmLock.lock();
        int temp = balance;

        try {
            Thread.sleep(100);
            temp = temp + amt;
            Thread.sleep(100);
            balance = temp;
            System.out.println("Total balance after deposit " + balance);
        } catch (InterruptedException e) {
            System.err.println("Exception while depositing");
        }
        atmLock.unlock();
        return temp;
    }
}
