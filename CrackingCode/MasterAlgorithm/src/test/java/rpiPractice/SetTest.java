package rpiPractice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetTest {

    Set empty;
    Set one;
    Set many;

    @Before
    public void setUp() {
        empty = new Set();
        one = new Set();
        many = new Set();
        one.add(1);
    }

    @Test
    public void isEmpty() {
       assertTrue(empty.isEmpty());
       assertFalse(one.isEmpty());
    }

    @Test
    public  void sizeTest() {
        assertEquals(0, empty.size());
        assertEquals(1,one.size());
    }

    @Test
    public  void addTest() {
        assertTrue(one.contains(1));
        assertFalse(one.contains(2));
    }

    @Test
    public void removeTest() {
        one.remove(1);
        assertFalse(one.contains(1));
        assertEquals(0, one.size());
    }

    @Test
    public void isUnique() {
        one.add(1);
        assertEquals(1,one.size());
    }

    @Test
    public void addMany() {

        many.add(1);
        many.add(2);
        many.add(3);
        many.add(4);
        many.add(5);

        assertEquals(5,many.size());
    }


    @Test
    public void getElementByIndex() {
        many.add(1);
        many.add(2);
        many.add(3);
        many.add(4);
        many.add(5);
        many.add(8);

        assertEquals(3,many.getElementByIndex(2));
        assertEquals(2,many.getElementByIndex(1));
        assertEquals(8,many.getElementByIndex(5));

    }

    @Test
    public void removeList() {
        many.add(1);
        many.add(2);
        many.add(3);
        many.add(4);
        many.add(5);

        many.removeList(3);
        assertEquals(many.size(),4);
        assertEquals(4,many.getElementByIndex(2));
        assertEquals(5,many.getElementByIndex(3));
        assertNull(many.getElementByIndex(4));
    }


}