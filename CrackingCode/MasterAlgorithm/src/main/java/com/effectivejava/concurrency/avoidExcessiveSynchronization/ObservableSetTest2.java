package com.effectivejava.concurrency.avoidExcessiveSynchronization;

import java.util.HashSet;

public class ObservableSetTest2 {
    //Adding functionality to remove element that will cause issue
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.err.println(element);
                if (element == 23) {
                    set.removeObserver(this);
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
