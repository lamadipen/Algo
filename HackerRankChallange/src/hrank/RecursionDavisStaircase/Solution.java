package hrank.RecursionDavisStaircase;

/**
 * Created by dipen on 6/7/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(climb(n));
        }

    }

    private static int climb(int n) {
        if(n < 0)
            return 0;

        if(n == 0)
            return 1;

        if(!map.containsKey(n)) {
            int count = climb(n-1) + climb(n-2) + climb(n-3);
            map.put(n, count);
        }
        return map.get(n);
    }
}


/**
 public static void staircase(int[] memo){
 memo[0] = 0;
 memo[1] = 1;    // 1
 memo[2] = 2;    // 1+1, 2
 memo[3] = 4;    // 1+1+1, 2+1, 1+2, 3

 for(int i = 4; i < memo.length; i++){
 memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
 }
 }

 public static void main(String[] args) {
 Scanner in = new Scanner(System.in);
 int s = in.nextInt();
 int inputs[] = new int[s];
 int max = 0;
 for(int a0 = 0; a0 < s; a0++){
 inputs[a0] = in.nextInt();
 if(inputs[a0] > max) { max = inputs[a0]; }
 }

 int[] memo = new int[max+1];

 staircase(memo);

 for(int i : inputs){
 System.out.println(memo[i]);
 }
 }

 **/