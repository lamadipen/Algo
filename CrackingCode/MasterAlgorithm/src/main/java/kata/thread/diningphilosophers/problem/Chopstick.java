package kata.thread.diningphilosophers.problem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    Lock lock;

    public Chopstick() {
        this.lock = new ReentrantLock();
    }

    public void pickup() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }
}
