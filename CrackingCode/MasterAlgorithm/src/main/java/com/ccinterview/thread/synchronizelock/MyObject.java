package com.ccinterview.thread.synchronizelock;

public class MyObject {

    //TODO remove the synchronized key to see different result
    //if the method is not synchronized different thread will access this object randomly
    //if the method is synchronied only one thread access it at a time, until the thread is done
    //with this method no other thread will be able to access it.
    public synchronized void print(String name) {
        try {
            System.out.println("Thread " + name + ".print(): Starting" );
            Thread.sleep(3000);
            System.out.println("Thread " + name + ".foo(): ending");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread " + name + ": interrupted");
        }

    }

    //static method are synchronized on the class lock
    //Two thread even with different object cannot access synchronized method at same time
    public static synchronized void foo() {

    }

    public void bar() {
        synchronized(this){
            System.out.println("Hello");
        }
    }
}
