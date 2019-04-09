package com.dp.cci.java8.stream.grouping;

import com.dp.cci.java8.domain.Dish;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class StreamGrouping {

    public static void main(String[] args) {

        Map<Dish.Type, List<Dish>> map = Dish.menu
                .stream()
                .collect(groupingBy(Dish::getType)); //Classification function is passed as parameter

        map.forEach((k, v) -> System.out.println(v));

        //Grouping by custom method
        Dish.menu
                .stream()
                .collect(groupingBy(dish -> {
                    if(dish.getCalories() <= 400)return CalorieLevel.DIET;
                    else if(dish.getCalories() <= 700) return CalorieLevel.NORMAL;
                    else return CalorieLevel.FAT;
                }));

        //MultiLevel grouping
        Dish.menu
                .stream()
                .collect(groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if(dish.getCalories() <= 400)return CalorieLevel.DIET;
                            else if(dish.getCalories() <= 700) return CalorieLevel.NORMAL;
                            else return CalorieLevel.FAT;
                        })
                ));

    }
}


enum CalorieLevel {DIET, NORMAL, FAT}