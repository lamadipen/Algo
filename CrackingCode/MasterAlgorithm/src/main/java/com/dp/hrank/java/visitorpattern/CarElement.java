package com.dp.hrank.java.visitorpattern;

interface CarElement {
    void accept(CarElementVisitor visitor);
}
