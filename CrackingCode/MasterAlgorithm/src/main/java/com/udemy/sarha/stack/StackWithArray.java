package com.udemy.sarha.stack;

import com.udemy.sarha.Employee;

import java.util.EmptyStackException;

public class StackWithArray {
    boolean isEmpty;
    int size;
    Employee[] arr = new Employee[10];
    int top;

    public boolean isEmpty() {
        return !(size > 0);
    }

    public int getSize() {
        return size;
    }

    public void push(Employee employee) {
        arr[size++] = employee;
        top = size - 1;
    }

    public boolean contains(Employee employee) {
        if(size < 1 ){
            return false;
        }
        for(int i= 0; i < size; i++){
            Employee temp = arr[i];

            if(temp.equals(employee))
                return  true;
        }
        return false;
    }

    public Employee pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Employee employee = arr[--size];
        arr[size] = null;
        return employee;
    }

    public Employee peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return arr[size -1];
    }
}
