package hrank.primeNumber;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i <n;i++)
        {
            int num =  sc.nextInt();
            if(isPrime(num)){
                System.out.println("Prime");
            }
            else{
                System.out.println("Not prime");
            }
        }
    }

    public static boolean isPrime(int num)
    {

        if(num < 2)
        {
            return false;
        }
        for(int i =2; i <= num/2;i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }
        return true;

    }
}
/** input
 30
 1
 4
 9
 16
 25
 36
 49
 64
 81
 100
 121
 144
 169
 196
 225
 256
 289
 324
 361
 400
 441
 484
 529
 576
 625
 676
 729
 784
 841
 907
 **/

/** output
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Not prime
 Prime
 **/