package com.cdk.effectiveJava.singleton;

//Third way of declaring singleton using enum with single element
public enum ElvisE {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Print the value leaving building");
    }
}
