package kata.thread.diningphilosophers.prioritizedChopstic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    int number;
    Lock lock;

    public Chopstick(int number) {
        this.number = number;
        this.lock = new ReentrantLock();
    }

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }
}
