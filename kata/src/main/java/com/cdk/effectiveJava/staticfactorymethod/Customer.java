package com.cdk.effectiveJava.staticfactorymethod;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.EnumSet;
import java.util.Random;
import java.util.ServiceLoader;

/** Lesson 2 Static Factoy method
 * **/
public class Customer {

    public static Customer getCustomer(){
        BigInteger.probablePrime(10, new Random());
        Boolean.valueOf("true");
        return new Customer();
    }


    public static void main(String[] args) {
        //EnumSet.complementOf()
    }

    public static void serviceProviderFramework() {
        //Service Provider Framework Pattern
//         Provider registration API
//        DriverManager.registerDriver();

//        Service Access API
//        DriverManager.getConnection()

//        service Provider interface
//        Driver

//        Java6 provided general purpose Service Provider Framework
//        ServiceLoader
    }

    public static void namingConventaionOfStaticFactoryMethod() {
//        Type conversion with single parameter
//        Date.from();

//        Aggregation method with multi parameters
//        EnumSet.of()

//        Verbose alternative of from and of
//        value.of()

//        instance or getInstance

//        create or newInstance

//        getType

//        newType

//            type
    }


}
