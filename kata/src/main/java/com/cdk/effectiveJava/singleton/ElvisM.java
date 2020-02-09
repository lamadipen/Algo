package com.cdk.effectiveJava.singleton;

public class ElvisM {
    private static  final ElvisM INSTANCE= new ElvisM();

    private ElvisM(){
    }

    public void leaveTheBuilding() {
        System.out.println("Leaving the Building");
    }

    public static ElvisM getInstance() {
        return  INSTANCE;
    }

    //(Item 89)
    private Object readResolve(){
        return INSTANCE;
    }
}
