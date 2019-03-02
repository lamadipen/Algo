package com.dp.cci.customdatastructure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomSetTest {

    CustomSet empty;
    CustomSet one;
    CustomSet many;


    @Before
    public void setUp() {
        empty = new CustomSet();
        one = new CustomSet();
        many = new CustomSet();

        one.add("one");
    }

    @Test
    public void isEmptyTest() {

        assertTrue(empty.isEmpty());
        assertFalse(one.isEmpty());
    }

    @Test
    public void sizeTest() {
        assertEquals(0, empty.getSize());
        assertEquals(1, one.getSize());
    }

    @Test
    public void addContainsTest() {
        many.add("one");
        many.add("two");
        many.add("three");
        many.add("four");

        assertTrue(one.contains("one"));
        assertFalse(one.contains("two"));
        assertTrue(many.contains("four"));
    }

    @Test
    public void removeTest() {
        one.remove("one");
        many.add("one");
        many.add("two");

        many.remove("one");

        assertTrue(one.isEmpty());
        assertFalse(one.contains("one"));
        assertFalse(many.contains("one"));
    }

    @Test
    public void isUnique() {
        many.add("one");
        many.add("one");
        many.add("two");
        many.add("two");

        assertEquals(2,many.getSize());

    }


}