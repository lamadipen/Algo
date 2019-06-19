package com.ccinterview.thread.DiningPhilosophers.deadlock;

public class Philosopher  extends Thread{
    private int bites = 100;
    private Chopstick left, right;

    public Philosopher(Chopstick left, Chopstick right){
        this.left = left;
        this.right = right;
    }

    public void eat(){
        pickup();
        chew();
        putdown();
    }

    private void putdown() {
        right.putdown();
        left.putdown();
    }

    private void chew() {
        System.out.println("Chewing" + currentThread().getName());
    }

    private void pickup() {
        left.pickup();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        right.pickup();
    }

    @Override
    public void run() {
        for(int i = 0; i < bites; i++){
            eat();
        }
    }
}
