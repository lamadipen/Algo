package com.effectivejava.concurrency;

import java.util.HashSet;

public class ObservableSetTest1 {
    //Working version
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        //Working example
        set.addObserver((s, e) -> System.out.println(e));
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
