package com.dp.cci.java8.stream.ch4;

import com.dp.cci.java8.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class StreamBasics {


    public static void main(String[] args) {
        getDishNameGTWithLimit();
        getDishNameWithMaxCalori();
        getVegeterianDish();
        getDistinctElements();
        skipElements();
        getFirst2MeatDish();
        getNameOfAllDish();
        flattern();
        getSquare();
        findingAndMatch();
        findAnyVegeterianDish();
        reduceFoldOperation();
    }

    public static void getDishNameGTWithLimit() {
        List<String> result = Dish.menu.stream()
                .filter(dish -> {
                    System.out.println("Filtering " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("Mapping " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(toList());
        System.out.println(result);
    }

    public static void getDishNameWithMaxCalori() {
        Dish dish = Dish.menu.stream().max(Comparator.comparing(Dish::getCalories)).get();
        System.out.println(dish);
    }

    public static void getVegeterianDish() {
        List<Dish> result = Dish.menu.stream()
                .filter(dish -> dish.isVegetarian())
                .collect(toList());
        System.out.println(result);
    }

    public static void getDistinctElements() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1, 1);
        List<Integer> result = numbers.stream()
                .filter(num -> num % 2 == 0)
                .distinct()
                .collect(toList());
        System.out.println(result);
    }

    public static void skipElements() {
        List<Dish> result = Dish.menu.stream()
                .filter(dish -> {
                    System.out.println(dish.getCalories());
                    return dish.getCalories() > 300;
                })
                .skip(6)
                .collect(toList());

        System.out.println(result);
    }

    public static void getFirst2MeatDish() {
        List<Dish> result = Dish.menu.stream()
                .filter(dish -> dish.getType().equals(Dish.Type.MEAT))
                .limit(2)
                .collect(toList());
        System.out.println(result);
    }

    public static void getNameOfAllDish() {
        List<String> result = Dish.menu.stream()
//                .map(dish -> dish.getType())
                .map(Dish::getName)
                .collect(toList());
        System.out.println(result);

        List<Integer> nameLength = Dish.menu.stream()
//                .map(dish -> dish.getType())
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(nameLength);
    }

    public static void flattern() {
        String[] arrayOfword = {"hello", "World"};
        List<String[]> unwantedResult = Arrays.stream(arrayOfword)
                .map(word -> {
                    String[] word1 = word.split("");
                    System.out.println(word);
                    return word1;
                })
                .distinct()
                .collect(toList());
        System.out.println(unwantedResult);

        List<String> result = Arrays.stream(arrayOfword)
                .map(word -> {
                    String[] word1 = word.split("");
                    System.out.println(word);
                    return word1;
                })
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(result);
    }

    public static void getSquare() {
        Integer[] numbers = {1, 2, 3, 4, 5};

        List<Integer> square = Arrays.stream(numbers)
                .map(num -> num * num)
                .collect(toList());
        System.out.println(square);

        Integer[] firstNumbers = {1, 2, 3};
        Integer[] secondNumbers = {3, 4};

        List<int[]> result = Arrays.stream(firstNumbers)
                .flatMap(first -> Arrays.stream(secondNumbers).map(second -> new int[]{first, second}))
                .collect(toList());
        System.out.println(result);

        List<int[]> pariDivisibleByThree = Arrays.stream(firstNumbers)
                .flatMap(first -> Arrays.stream(secondNumbers)
                        .filter(second -> (first+second)%3 == 0)
                        .map(second -> new int[]{first, second}))
                .collect(toList());
        System.out.println(pariDivisibleByThree);
    }

    public static void findingAndMatch() {
        boolean isVeg = Dish.menu.stream().allMatch(Dish::isVegetarian);
        System.out.println(isVeg);
        boolean isHealthy = Dish.menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);
        boolean isNotHealthy = Dish.menu.stream().noneMatch(dish -> dish.getCalories() > 1000);
        System.out.println(isNotHealthy);
    }

    public static void findAnyVegeterianDish() {
        Optional<Dish> anyVeg = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println(anyVeg.get());
        Optional<Dish> firstVege = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findFirst();
        System.out.println(firstVege.get().getCalories());
    }

    public static void reduceFoldOperation() {
        Integer totalCalori = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(0, (cal1, cal2) -> cal1 + cal2);

        System.out.println(totalCalori);

        Optional<Integer> multiPly = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce((cal1, cal2) -> cal1 * cal2);

        System.out.println(multiPly.get());

        Optional<Integer> minCalori = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(Integer::min);

        System.out.println(minCalori.get());

        Optional<Integer> maxCalori = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce((a,b) -> a > b ? a : b);

        System.out.println(maxCalori.get());

        //get number of dishes in menu
        Dish.menu.stream()
                .map(d -> 1)
                .reduce(0,(a, b) -> a + b);

        Dish.menu.stream().count();

    }
}
