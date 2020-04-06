package com.effectivejava.concurrency.preferconcurrencyutilities;

import java.util.concurrent.ConcurrentHashMap;

public class Intern {
    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();


    //Less efficient code
//    public static String intern(String s) {
//        String previousValue = map.putIfAbsent(s, s);
//        return previousValue == null ? s : previousValue;
//    }

    //Concurrent canonicalizing  map atop concurrentMap - faster
    public static String intern(String s) {
        String previousValue = map.get(s);
        if (previousValue == null) {
            previousValue = map.putIfAbsent(s, s);
            if (previousValue == null) {
                return s;
            }
        }
        return previousValue == null ? s : previousValue;
    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        intern("Apple");
        long endTime = System.currentTimeMillis();

        System.out.println("Time Difference " + (endTime - startTime));
    }


}



