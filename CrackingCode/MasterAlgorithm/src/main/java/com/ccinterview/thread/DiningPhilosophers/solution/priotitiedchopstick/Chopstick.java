package com.ccinterview.thread.DiningPhilosophers.solution.priotitiedchopstick;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    private Lock lock;
    private int number;

    public Chopstick(int number) {
        lock = new ReentrantLock();
        this.number = number;
    }

    public void pickup() {
        System.out.println("Pick up with all or nothing");
        lock.lock();
    }

    public void putdown() {
        System.out.println("Put Down with all or nothing");
        lock.unlock();
    }

    public int getNumber() {
        return number;
    }
}
