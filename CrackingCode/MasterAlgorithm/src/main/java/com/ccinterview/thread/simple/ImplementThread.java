package com.ccinterview.thread.simple;

public class ImplementThread implements Runnable {
    public int count = 0;
    @Override
    public void run() {
        System.out.println("I am implemented thread");

        while(count < 5){
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println("Implemented thread count :: "+count);
        }
    }
}
