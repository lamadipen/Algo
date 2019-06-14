package com.udemy.sarha.queue;

import com.udemy.sarha.Employee;

import java.util.NoSuchElementException;

public class CustomQueue {


    Employee[] employees = new Employee[10];
    int front;
    int back;

    public static void main(String... args) {
        CustomQueue cq = new CustomQueue();
        cq.queue(new Employee(10,"Dipen","Lama"));
        System.out.println(cq.isEmpty());
        System.out.println(cq.count());
    }

    private boolean isEmpty() {
        return count() == 0;
    }

    private void queue(Employee employee){
        if(back == count()){
            Employee[] newArray = new Employee[2 * employees.length];
            System.arraycopy(employees,0, newArray,0 ,employees.length);
            employees = newArray;
        }
       employees[back++] = employee;
    }

    private Employee dequeue(){
        if(count() == 0){
            throw new NoSuchElementException();
        }
        Employee employee = employees[front];
        employees[front] = null;
        front++;
        if(count() == 0){
            front = 0;
            back = 0;
        }
        return employee;
    }

    private int count() {
        return back -front;
    }

    public Employee peek() {
        if(count() == 0 ){
            throw new NoSuchElementException();
        }
        return employees[front];
    }

    public void print(){
        for(int i =front; i < back; i++){
            System.out.println(employees[i]);
        }
    }
}
