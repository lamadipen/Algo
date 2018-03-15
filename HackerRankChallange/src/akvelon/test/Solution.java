package akvelon.test;

import java.util.*;

/**
 * Created by dipen on 6/29/2017.
 */
class Solution {


    public static void main(String... args) {
        int A[] = {40, 40, 100, 80, 20};
        int B[] = {3, 3, 2, 2, 3};
        int people = 5;
        int weight = 200;
        int value = solution1(A, B, people, weight);
        System.out.println(solution1(A, B, people, weight));
/*
        int X[] = {60, 80, 40};
        int Y[] = {2, 3, 5};
        people = 5;
        weight = 200;
        System.out.println(solution1(X, Y, people, weight));*/
    }

    private static int solution1(int[] A, int[] B, int X, int Y) {


        int noPeople =0;
        int totalWeight =0;
        int noStop = 0;

        Set<Integer> stop = new HashSet();

        if(A == null || B == null || A.length ==0 || B.length == 0 || X< 1 || Y <1 )
        {
            return 0;
        }


        for(int i=0; i < A.length; i++)
        {
            noPeople++;
            totalWeight += A[i];

            if(noPeople > X || totalWeight > Y)
            {
                noStop += stop.size();
                stop.clear();
                noPeople = totalWeight= 0;
                i--;
                noStop++;
            }
            else
            {
                stop.add(B[i]);
            }
        }

        return noStop+1+stop.size();
    }


}