package com.dp.hrank.visitorpattern;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashset {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        //Write your code here
        //System.out.println(Arrays.toString(pair_right));
        Set<String> set = new HashSet();
        for(int i = 0 ; i < t; i++){
            set.add(pair_left[i]+" "+pair_right[i]);
            System.out.println(set.size());
        }
    }
}

/**
 You are given  pairs of strings. Two pairs  and  are identical if  and . That also implies  is not same as . After taking each pair as input, you need to print number of unique pairs you currently have.

 Complete the code in the editor to solve this problem.

 Input Format

 In the first line, there will be an integer  denoting number of pairs. Each of the next  lines will contain two strings seperated by a single space.

 Constraints:

 Length of each string is atmost  and will consist lower case letters only.
 Output Format

 Print  lines. In the  line, print number of unique pairs you have after taking  pair as input.

 Sample Input

 5
 john tom
 john mary
 john tom
 mary anna
 mary anna
 Sample Output

 1
 2
 2
 3
 3
 Explanation

 After taking the first input, you have only one pair: (john,tom)
 After taking the second input, you have two pairs: (john, tom) and (john, mary)
 After taking the third input, you still have two unique pairs.
 After taking the fourth input, you have three unique pairs: (john,tom), (john, mary) and (mary, anna)
 After taking the fifth input, you still have three unique pairs.
 */
