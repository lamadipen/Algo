package com.cdk;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzClassTest {

    @Test
    public void fizzPrintTest(){
        FizzClass fc = new FizzClass();
        assertEquals(fc.fizzPrint(1),"1");
        assertEquals(fc.fizzPrint(2),"2");
        assertEquals(fc.fizzPrint(3),"fizz");
        assertEquals(fc.fizzPrint(6),"fizz");
//        assertEquals(fc.fizzPrint(10),"buzzz");
//        assertEquals(fc.fizzPrint(15),"fizzbuzz");

    }

    @Test
    public void testPalandorm(){
        FizzClass fc = new FizzClass();
//        assertTrue(fc.palandrom("abba"));
//        assertTrue(fc.palandrom("abccba"));
//        assertFalse(fc.palandrom("abcdba"));
        assertEquals(fc.palandrom("abccfba"),"abccba");
        assertEquals(fc.palandrom("abccfghba"),"abccba");
//        assertEquals(fc.palandrom("abccfhghba"),"abccba");
        assertEquals(fc.palandrom("abccba"),"abccba");
        assertEquals(fc.palandrom("ab"),"a");
        assertEquals(fc.palandrom("cababc"),"abccba");

    }


//    //payament balance will allow him
//    Customer
//    Account
//
//    Soda
//    Cart
//    Payment



    //web site onlie recharge

    //credit and bank

    //login




}