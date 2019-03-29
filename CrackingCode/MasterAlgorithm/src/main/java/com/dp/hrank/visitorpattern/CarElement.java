package com.dp.hrank.visitorpattern;

interface CarElement {
    void accept(CarElementVisitor visitor);
}
