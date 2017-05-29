package hrank.FibonacciModified;

/**
 * Created by dipen on 5/10/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);

        BigInteger t1 = sc.nextBigInteger();
        BigInteger t2 = sc.nextBigInteger();
        int n = sc.nextInt();

        BigInteger [] fibArray = new BigInteger[n];
        fibArray[0] = t1;
        fibArray[1] = t2;

        for(int i=2; i < fibArray.length; i++)
        {
            fibArray[i] = fibArray[i-2].add(fibArray[i-1].pow(2)) ;
        }

        System.out.println( fibArray[n-1]);

    }

    public void calcFib(int n)
    {

    }
}