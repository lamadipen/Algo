package hrank.VaccationSolution;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dipen on 5/18/2017.
 */
public class Solution {

    public static int solution(int[] A) {

        int startDay = 0, endDay = startDay + 1;
        Set<Integer> destination = new HashSet<Integer>();

        for (int i = 0; i < A.length; i++) {
            if (A[startDay] == A[i] && i != 0) {
                startDay++;
                endDay = startDay + 1;

            } else {
                if (!destination.contains(A[i])) {
                    endDay = i;
                }
            }
            destination.add(A[i]);
        }
        return endDay - startDay + 1;
    }

    public static void main(String [] args)
    {
        int a[]={7,3,7,3,1,3,4,1};
        System.out.println(solution(a));
    }
}
