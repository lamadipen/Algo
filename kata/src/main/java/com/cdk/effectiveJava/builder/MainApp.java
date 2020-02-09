package com.cdk.effectiveJava.builder;

public class MainApp {
    public static void main(String[] args) {
        Pizza nyPizza = new NyPizza
                .Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.HAM)
                .build();

        System.out.println(nyPizza.toString());

        nyPizza.toppings.forEach(
                System.out::println

        );
    }
}
