package hrank.BirthdayCakeCandles;

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
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int height[] = new int[n];

        Map<Integer, Integer> map = new HashMap();
        int maxHeight =0;

        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextInt();

            if(maxHeight < height[height_i])
            {
                maxHeight = height[height_i];
            }

            if(map.containsKey(height[height_i]))
            {
                int count = map.get(height[height_i]);
                map.put(height[height_i],count+1);
            }
            else
            {
                map.put(height[height_i],1);
            }
        }

        System.out.println(map.get(maxHeight));
    }
}
