package com.ccinterview.thread.synchronizelock;

public class ThreadApp {

    public static void main(String... args){
        //Difference reference both thread can call MyObject.print()
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();

        MyClass th1 = new MyClass(obj1,"Dipen");
        MyClass th2 = new MyClass(obj2, "Sunita");

        th1.start();
        th2.start();

        System.out.println("Two Thread accessing same reference ==================");

        //same reference to obj.Only one will be allowed to call foo.
        MyObject obj3 = new MyObject();

        MyClass th3 = new MyClass(obj3,"Hari");
        MyClass th4 = new MyClass(obj3, "Shyam");

        th3.start();
        th4.start();

    }
}
