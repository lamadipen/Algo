package com.ccinterview.thread.DiningPhilosophers.solution.allornothing;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    private Lock lock;

    public Chopstick() {
        lock = new ReentrantLock();
    }

    public boolean pickup() {
        System.out.println("Pick up with all or nothing");
        return lock.tryLock();
    }

    public void putdown() {
        System.out.println("Put Down with all or nothing");
        lock.unlock();
    }
}
