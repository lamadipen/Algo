package com.cdk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzClassTest {

    @Test
    public void fizzPrintTest() {
        FizzClass fc = new FizzClass();
        assertEquals(fc.fizzPrint(1), "1");
        assertEquals(fc.fizzPrint(2), "2");
        assertEquals(fc.fizzPrint(3), "fizz");
        assertEquals(fc.fizzPrint(6), "fizz");
//        assertEquals(fc.fizzPrint(10),"buzzz");
//        assertEquals(fc.fizzPrint(15),"fizzbuzz");

    }

    @Test
    public void testPalandorm() {
        FizzClass fc = new FizzClass();
//        assertTrue(fc.palandrom("abba"));
//        assertTrue(fc.palandrom("abccba"));
//        assertFalse(fc.palandrom("abcdba"));
//        assertEquals(fc.palandrom("abccfba"), "abccba");
//        assertEquals(fc.palandrom("abccfghba"), "abccba");
//        assertEquals(fc.palandrom("abccfhghba"),"abccba");
//        assertEquals(fc.palandrom("abccba"), "abccba");
//        assertEquals(fc.palandrom("ab"), "a");
        assertEquals(fc.palandrom("cababc"), "abccba");

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
    Fiz fiz;

    @Before
    public void setup(){
        fiz = new Fiz();
    }


    @Test
    public void testFizz() {
        Assert.assertNotNull(new Fiz());
    }

    @Test
    public  void testWithOne(){
        Assert.assertEquals("fiz",fiz.checkFizBuzz(1));
    }

    @Test
    public  void testWithTwo(){
        Assert.assertEquals("buzz", fiz.checkFizBuzz(2));
    }


    @Test
    public  void testWithRandom(){
        Assert.assertEquals("fiz", fiz.checkFizBuzz(3));
        Assert.assertEquals("buzz", fiz.checkFizBuzz(4));
        Assert.assertEquals("fiz", fiz.checkFizBuzz(5));
        Assert.assertEquals("buzz", fiz.checkFizBuzz(9));
    }
}

class Fiz{

    public String checkFizBuzz(int i) {
        if(i % 2 != 0){
            return "fiz";
        }else{
            return "buzz";
        }

    }
}