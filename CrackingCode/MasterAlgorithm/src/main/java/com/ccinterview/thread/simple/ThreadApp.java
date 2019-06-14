package com.ccinterview.thread.simple;

public class ThreadApp {
    public static void main(String... args){
        ExtendThread et = new ExtendThread();
        ImplementThread it = new ImplementThread();
        Thread ith = new Thread(it);

        et.start();
        ith.start();


    }
}
