package com.dp.cci.customdatastructure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MySetTest {

    MySet empty;
    MySet one;
    MySet many;

    @Before
    public void setUp() {
        empty = new MySet();
        one = new MySet();
        many = new MySet();
    }

    @Test
    public void isEmptyTest() {
        assertTrue(empty.isEmpty());
    }

    @Test
    public void getSizeTest() {
        assertEquals(0, empty.getSize());
    }

    @Test
    public void addTest() {
        one.add("one");

        many.add("two");
        many.add("three");
        many.add("four");
        many.add("two");

        assertFalse(one.isEmpty());
        assertEquals(1, one.getSize());

        assertEquals(3, many.getSize());
    }

    @Test
    public void containsTest() {
        MySet one = new MySet();
        one.add("one");
        assertTrue(one.contains("one"));
        assertFalse(one.contains("two"));
    }

    @Test
    public void removeTest() {
        one.add("one");
        one.remove("one");

        assertTrue(one.isEmpty());
        assertEquals(0, one.getSize());
    }
}