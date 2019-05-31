package com.udemy.sarha.stack;

import com.udemy.sarha.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

/** Coustom stack using LinkedList to restrict developers from using other feature of LinkedList*/
public class LinkedStack {

    LinkedList<Employee> stack;

    public LinkedStack() {
        stack = new LinkedList<>();
    }

    public void push(Employee employee) {
        stack.push(employee);
    }

    public Employee pop() {
        return stack.pop();
    }

    public Employee peek() {
        return stack.peek();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void print() {
        ListIterator it = stack.listIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

