package com.cdk.leeteasy;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 Jewels and Stones
Easy
You're given strings J representing the types of stones that are jewels, and S representing the stones you
have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have
are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case
sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct

*/
public class JewelsAndStone {

    @Test
    public void numJewelsInStonesTest(){
        Assert.assertEquals(0,numJewelsInStones("z", "ZZ"));
        Assert.assertEquals(3,numJewelsInStones("aA", "aAAbbbb"));
    }

    public int numJewelsInStones(String J, String S) {
        char[] jewels = J.toCharArray();
        char[] stones = S.toCharArray();
        int count = 0;
        for(int i =0; i < jewels.length; i++){
            for (Character c : stones) {
                if(jewels[i] == c){
                    count++;
                }
            }
        }
        return count;
    }
}
