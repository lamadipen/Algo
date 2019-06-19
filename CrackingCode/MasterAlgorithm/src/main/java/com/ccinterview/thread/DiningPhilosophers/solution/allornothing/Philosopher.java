package com.ccinterview.thread.DiningPhilosophers.solution.allornothing;


public class Philosopher extends Thread{
    private int bites = 100;
    private Chopstick left, right;

    public Philosopher(Chopstick left, Chopstick right){
        this.left = left;
        this.right = right;
    }

    public void eat(){
        if(pickup()){
            chew();
            putdown();
        }
    }

    private void putdown() {
        right.putdown();
        left.putdown();
    }

    private void chew() {
        System.out.println("Chewing" + currentThread().getName());
    }

    private boolean pickup() {
        if(!left.pickup()){
            return false;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(!right.pickup()){
            System.out.println("Putting Down the left");
            left.putdown();
            return false;
        }
        return  true;
    }

    @Override
    public void run() {
        for(int i = 0; i < bites; i++){
            eat();
        }
    }
}
