package com.ccinterview.thread.DiningPhilosophers.solution.allornothing;


public class MainApp {
    public static void main(String... args) {
        Chopstick left = new Chopstick();
        Chopstick right = new Chopstick();

        Philosopher p1 = new Philosopher(left, right);
        Philosopher p2 = new Philosopher(left, right);
        Philosopher p3 = new Philosopher(left, right);
        Philosopher p4 = new Philosopher(left, right);

        p1.start();
        p2.start();
        p4.start();
        p3.start();
    }

}
