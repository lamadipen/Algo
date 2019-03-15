package com.dp.cci.java8.stream.ch5;

import com.dp.cci.java8.domain.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class SpecilaStream {

    public static void main(String... args) {
        int sum = Dish.menu.stream().mapToInt(Dish::getCalories).sum();

        OptionalInt max = Dish.menu.stream().mapToInt(Dish::getCalories).max();
        int maxResult = max.orElse(1);

        IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        String s = "A";
        System.out.println((int)'a');
        System.out.println((int)'b');
    }
}
