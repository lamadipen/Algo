package com.cdk.effectiveJava.enforceNoninstantiability;

import java.util.Arrays;
import java.util.Collections;

public class MyClass {

    private MyClass(){
        //This class cannot be instated and subclassed
        //The subclass must invoke the constructor of superclass and subclass cannot
        //access the constructor of super class in this case
    }
    public static void main(String[] args) {
        //java.lang.Math/java.utils.Arrays is example of enforce noninstantability
        //Math
//        Arrays
//        Collections
    }
}
