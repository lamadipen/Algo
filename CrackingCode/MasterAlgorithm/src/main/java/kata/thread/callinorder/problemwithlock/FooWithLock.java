package kata.thread.callinorder.problemwithlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This will fail as a lock allows only one thread to enter the part that's
 * locked and the lock is not shared with any other threads.
 * <p>
 * https://stackoverflow.com/questions/2332765/lock-mutex-semaphore-whats-the-difference
 */
public class FooWithLock {
    Lock firstLock, secondLock;
    int pauseTime = 1000; //1 sec

    public FooWithLock() {
        firstLock = new ReentrantLock();
        secondLock = new ReentrantLock();

        firstLock.lock();
        secondLock.lock();
    }

    public void first() {
        firstLock.unlock();
        System.out.println("Running first method");
    }

    public void second() {
        firstLock.lock();
        firstLock.unlock();
        System.out.println("Running second method");
        secondLock.unlock();
    }

    public void third() {
        secondLock.lock();
        secondLock.unlock();
        System.out.println("Running third method");
    }
}
