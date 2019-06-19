package com.ccinterview.thread.DiningPhilosophers.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    private Lock lock;

    public Chopstick() {
        lock = new ReentrantLock();
    }

    public void pickup() {
        System.out.println("Pick up");
        lock.lock();
    }

    public void putdown() {
        System.out.println("Put Down");
        lock.unlock();
    }
}
