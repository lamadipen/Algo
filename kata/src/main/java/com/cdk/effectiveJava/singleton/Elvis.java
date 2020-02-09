package com.cdk.effectiveJava.singleton;

public class Elvis {
    public static  final Elvis INSTANCE= new Elvis();

    private Elvis(){
    }

    public void leaveTheBuilding() {
        System.out.println("Leaving the Building");
    }
}
