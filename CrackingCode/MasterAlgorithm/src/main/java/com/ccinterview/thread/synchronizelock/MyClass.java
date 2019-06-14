package com.ccinterview.thread.synchronizelock;

public class MyClass extends Thread{
    private String name;
    private MyObject myObject;

    public MyClass(MyObject myObject, String name){
        this.myObject = myObject;
        this.name = name;
    }

    @Override
    public void run() {
        myObject.print(name);
    }
}
