package com.cdk.leeteasy;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Maximum69Number {
//    public int maximum69Number (int num) {
//        char[] chars = Integer.toString(num).toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if(chars[i] != 9){
//                chars[i] = 9;
//                break;
//            }
//        }
//
//        String sb = Stream.of(chars).map(String::valueOf).collect(Collectors.joining());
//
//        return Integer.parseInt(sb.toString());
//    }

    @Test
    public void maximum69NumberTest(){
    //    Assert.assertEquals(9999, maximum69Number(9999));
        Assert.assertEquals(9969, maximum69Number(9669));
    }


    public int maximum69Number (int num) {

        int res=0;
        int factor=1000;
        boolean found = false;

        while (factor >= 1)
        {
            if (num/factor == 6 && !found)
            {
                res+= 9*factor;
                found = true;
                num-= 6*factor;
            }
            else if (found)
            {
                res+= num;
                return res;
            }
            else
            {
                res+= (num/factor)*factor;
                num-= (num/factor)*factor;
            }
            factor/=10;
        }


        return res;

    }
}

/*
https://leetcode.com/problems/maximum-69-number/

Given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).



Example 1:

Input: num = 9669
Output: 9969
Explanation:
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.
Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.
Example 3:

Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.


Constraints:

1 <= num <= 10^4
num's digits are 6 or 9.
*/
