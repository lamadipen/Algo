package kata.thread.diningphilosophers.allornothings;

import java.util.concurrent.locks.Lock;

public class Chopstick {
    Lock lock;

    public Chopstick(Lock lock) {
        this.lock = lock;
    }

    public boolean pickUp() {
        return lock.tryLock();
    }

    public void putDown() {
        lock.unlock();
    }
}
