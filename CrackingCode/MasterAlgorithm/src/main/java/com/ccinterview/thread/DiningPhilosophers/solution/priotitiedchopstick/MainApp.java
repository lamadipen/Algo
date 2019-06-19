package com.ccinterview.thread.DiningPhilosophers.solution.priotitiedchopstick;


public class MainApp {
    public static void main(String... args) {
        Chopstick ch1 = new Chopstick(1);
        Chopstick ch2= new Chopstick(2);
        Chopstick ch3= new Chopstick(3);
        Chopstick ch4= new Chopstick(4);

        Philosopher p1 = new Philosopher(1,ch1, ch4);
        Philosopher p2 = new Philosopher(2,ch2, ch1);
        Philosopher p3 = new Philosopher(3,ch3, ch2);
        Philosopher p4 = new Philosopher(4,ch4, ch1);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }

}
