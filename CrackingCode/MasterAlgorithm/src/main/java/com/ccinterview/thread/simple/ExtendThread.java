package com.ccinterview.thread.simple;

public class ExtendThread extends Thread {
    public int count =0;
    @Override
    public void run(){

           System.out.println("I am Extended thread starting");

           while(count < 5){
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               count++;
               System.out.println("Extended Thread Count ::" + count);
           }
        System.out.println("I am Extended thread ending");
    }
}
