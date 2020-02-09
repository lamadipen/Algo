package com.cdk.stringpermutation;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class PermutationTest {

    @Test
    public void permutaion(){
        printPermutaion("abc", "");
        Assert.assertTrue(true);
    }

    public static void printPermutaion(String input,String ans) {
        if (input.length() == 0) {
            System.out.println(ans+" ");
        }
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            String result = input.substring(0,i)+
                    input.substring(i+1);

            printPermutaion(result,ans+ch);
        }
    }

    /*  i=0 -> bc , a
            -> c  , ab
            -> "" , abc
        i=1 -> ac  , b
            -> c   , ba
            -> ""  , bac

    */

    public static void main(String[] args) {
        System.out.println("here".substring(0,1));

        printPermutaion("abc", "");
    }

    @Test
    public void testPossiblePermutation(){
        possiblePermutation("ABC", 2);
    }

    private void possiblePermutation(String numberOfObject, int sample) {
        char [] buffer = new char[2];
        possiblePermutation(numberOfObject,0, buffer, 0);
    }

    public void possiblePermutation(String numberOfObject, int pointer, char[] buffer, int bufferIndex) {
        if(buffer.length  == bufferIndex){
            printBuffer(buffer);
            return;
        }

        for(int i = pointer ; i <= numberOfObject.length() - 1; i++){
            if(buffer.length  == bufferIndex){
                bufferIndex = 0;
            }
            buffer[bufferIndex++] = numberOfObject.charAt(i);
            possiblePermutation(numberOfObject, pointer + 1, buffer, bufferIndex);
        }
    }

    private void printBuffer(char[] buffer) {
        for (char i : buffer) {
            System.out.print(i);
        }
    }

}