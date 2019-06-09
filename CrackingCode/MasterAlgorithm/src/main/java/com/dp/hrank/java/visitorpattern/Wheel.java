package com.dp.hrank.java.visitorpattern;

public class Wheel implements  CarElement{
    private final String name;

    public Wheel(String name) {
        this.name = name;
    }


    @Override
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }
}
