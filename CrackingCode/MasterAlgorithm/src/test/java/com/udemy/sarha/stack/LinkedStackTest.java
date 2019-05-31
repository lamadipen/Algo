package com.udemy.sarha.stack;

import com.udemy.sarha.Employee;
import org.junit.Test;

public class LinkedStackTest {

    @Test
    public void print() {
        LinkedStack linkedStack = new LinkedStack();

        linkedStack.push(new Employee(1,"Dipen", "Lama"));
        linkedStack.push(new Employee(1,"Hari", "Lama"));
        linkedStack.push(new Employee(1,"shyam", "Lama"));
        linkedStack.push(new Employee(1,"Sameer", "Lama"));
        linkedStack.push(new Employee(1,"Ishwor", "Lama"));

        linkedStack.print();
    }
}