package com.dp.hrank;

import java.util.*;

public class JavaDequeue {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        Deque deque = new ArrayDeque<Integer>();
        int n = sc.nextInt();
        int m = sc.nextInt();

        Set set = new HashSet<Integer>();
        int maxUnique = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            deque.add(num);
            set.add(num);

            if(deque.size() >= m){
                Integer poll = (Integer) deque.poll();
                maxUnique = set.size() > maxUnique? set.size(): maxUnique;
                if(!deque.contains(poll))set.remove(poll);

            }
        }

        System.out.println(maxUnique);
    }
}
/*

In this problem, you are given  integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size .

Note: Time limit is  second for this problem.

Input Format

The first line of input contains two integers  and : representing the total number of integers and the size of the subarray, respectively. The next line contains  space separated integers.

Constraints




The numbers in the array will range between .

Output Format

Print the maximum number of unique integers among all possible contiguous subarrays of size .

Sample Input

6 3
5 3 5 2 3 2
Sample Output

3

*/