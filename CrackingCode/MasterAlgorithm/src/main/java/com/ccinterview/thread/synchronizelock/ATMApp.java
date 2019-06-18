package com.ccinterview.thread.synchronizelock;

public class ATMApp {

    public static void main(String... args) {

        Runnable depositeThread = ()-> {
            int deposit = new ATMLock().deposit(100);
            System.out.println(deposit);
        };

        Runnable  withdrawThread= () -> {
            int withdraw = new ATMLock().withdraw(200);
            System.out.println(withdraw);
        };



        Thread t1 = new Thread(depositeThread);
        Thread t2 = new Thread(withdrawThread);

        t1.start();
        t2.start();


    }
}

