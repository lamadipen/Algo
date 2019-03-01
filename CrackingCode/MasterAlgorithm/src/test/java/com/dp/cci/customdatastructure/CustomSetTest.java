package com.dp.cci.customdatastructure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomSetTest {
    CustomSet csEmpty;
    CustomSet csOne;
    CustomSet csMany;

    @Before
    public void setUp() {
        csEmpty = new CustomSet();
        csOne = new CustomSet();
        csMany = new CustomSet();
    }
    @Test
    public void isEmptyTest() {
        assertTrue(csEmpty.isEmpty());
    }

    @Test
    public void getSizeTest(){
        assertEquals(0,csEmpty.getSize());
    }

    @Test
    public void addTest() {
        csMany.add(1);
        csMany.add(2);
        csMany.add(3);
        csMany.add(4);

        csOne.add(1);
        assertTrue(csEmpty.isEmpty());
        assertEquals(0, csEmpty.getSize());
        assertEquals(4, csMany.getSize());
    }

    @Test
    public void removeTest() {
        CustomSet cs = new CustomSet();
        cs.add(1);
        cs.remove(1);

        assertEquals(0,cs.getSize());
        assertFalse(cs.contains(1));
    }

    @Test
    public void uniqueTest() {
        CustomSet cs = new CustomSet();
        cs.add(1);
        cs.add(1);

        assertEquals(1,cs.getSize());
    }


}