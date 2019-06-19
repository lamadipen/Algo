package com.ccinterview.thread.DiningPhilosophers.solution.priotitiedchopstick;


public class Philosopher extends Thread{
    private int bites = 10;
    private Chopstick lower, higher;
    private int index;

    public Philosopher(int i, Chopstick left, Chopstick right){
       index = i;

       if(left.getNumber() < right.getNumber()){
           System.out.println("### pick left first ###");
           this.lower = left;
           this.higher = right;
       }else{
           System.out.println("### pick right first ###");
           this.lower = right;
           this.higher = left;
       }
    }

    public void eat(){
            pickup();
            chew();
            putdown();
    }

    private void putdown() {
        higher.putdown();
        lower.putdown();
    }

    private void chew() {
        System.out.println("Chewing" + currentThread().getName());
    }

    private void pickup() {
        lower.pickup();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        higher.pickup();
    }

    @Override
    public void run() {
        for(int i = 0; i < bites; i++){
            eat();
        }
    }
}
