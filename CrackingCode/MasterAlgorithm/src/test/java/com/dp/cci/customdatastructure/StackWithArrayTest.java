package com.dp.cci.customdatastructure;

import com.udemy.sarha.Employee;
import com.udemy.sarha.stack.StackWithArray;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackWithArrayTest {
    Employee employee1;
    Employee employee2;
    Employee employee3;
    Employee employee4;
    Employee employee5;

    StackWithArray empty = new StackWithArray();
    StackWithArray one = new StackWithArray();
    StackWithArray many = new StackWithArray();

    @Before
    public void setUp() {
        employee1 = new Employee(1, "Dipen", "lama");
        employee2 = new Employee(2, "Ram", "lama");
        employee3 = new Employee(3, "Hari", "lama");
        employee4 = new Employee(4, "Shyam", "lama");
        employee5 = new Employee(5, "Shyam", "lama");

        one.push(employee1);

        many.push(employee1);
        many.push(employee2);
        many.push(employee3);
        many.push(employee4);
    }

    @Test
    public void isEmptyTest() {
        assertTrue(empty.isEmpty());

        assertFalse(one.isEmpty());

        assertFalse(many.isEmpty());

    }

    @Test
    public void getSizeTest() {
        assertEquals(0,empty.getSize());
        assertEquals(1,one.getSize());
        assertEquals(4,many.getSize());
    }

    @Test
    public void containsTest() {
        assertFalse(empty.contains(employee1));
        assertTrue(one.contains(employee1));
        assertFalse(one.contains(employee2));

        assertTrue(many.contains(employee4));
        assertFalse(many.contains(employee5));
    }

    @Test
    public void popTest() {
        assertEquals(one.pop(), employee1);
        assertTrue(one.isEmpty());
        assertFalse(one.contains(employee1));
    }

    @Test
    public void peekTest() {
        assertEquals(one.peek(), employee1);
        assertFalse(one.isEmpty());
    }
}