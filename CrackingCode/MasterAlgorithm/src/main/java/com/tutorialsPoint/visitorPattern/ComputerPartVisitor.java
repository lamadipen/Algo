package com.tutorialsPoint.visitorPattern;

interface ComputerPartVisitor {
    void visit(Computer computer);
    public void visit(Monitor monitor);
    void visit(Keyboard keyboard);
    void visit(Mouse mouse);
}
