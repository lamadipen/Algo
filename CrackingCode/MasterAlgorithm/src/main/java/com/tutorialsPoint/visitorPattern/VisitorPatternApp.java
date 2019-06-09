package com.tutorialsPoint.visitorPattern;

public class VisitorPatternApp {
    public static void main(String... args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
