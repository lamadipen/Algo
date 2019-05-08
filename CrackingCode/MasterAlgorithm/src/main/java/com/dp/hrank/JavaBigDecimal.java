package com.dp.hrank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class JavaBigDecimal {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Write your code here
        Arrays.sort(s, reverseOrder(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1 == null || o2 == null){
                    return -1;
                }
                BigDecimal a = new BigDecimal(o1);
                BigDecimal b = new BigDecimal(o2);

                return a.compareTo(b);
            }
        }));
// Solution that passed in the hacker rank
//        Comparator<String> tComparator = (o1, o2) -> {
//            BigDecimal a = new BigDecimal(o1);
//            BigDecimal b = new BigDecimal(o2);
//            return a.compareTo(b);
//        };
//
//        List<String> collect = Arrays.stream(s)
//                .sorted(tComparator)
//                .collect(Collectors.toList());


//        Comparator<String> comparator = new Comparator<String>(){
//            public int compare(String s1, String s2){
//                if( s1 == null || s2 == null)return 0;
//
//                BigDecimal d1 = new BigDecimal(s1);
//                BigDecimal d2 = new BigDecimal(s2);
//                return d2.compareTo(d1);
//            }
//
//        };
//
//        Arrays.sort(s, comparator);


        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }

}
/**
 * Java's BigDecimal class can handle arbitrary-precision signed decimal numbers. Let's test your knowledge of them!
 * <p>
 * Given an array, , of  real number strings, sort them in descending order — but wait, there's more! Each number must be printed in the exact same format as it was read from stdin, meaning that  is printed as , and  is printed as . If two numbers represent numerically equivalent values (e.g., ), then they must be listed in the same order as they were received as input).
 * <p>
 * Complete the code in the unlocked section of the editor below. You must rearrange array 's elements according to the instructions above.
 * <p>
 * Input Format
 * <p>
 * The first line consists of a single integer, , denoting the number of integer strings.
 * Each line  of the  subsequent lines contains a real number denoting the value of .
 * <p>
 * Constraints
 * <p>
 * Each  has at most  digits.
 * Output Format
 * <p>
 * Locked stub code in the editor will print the contents of array  to stdout. You are only responsible for reordering the array's elements.
 * <p>
 * Sample Input
 * <p>
9
-100
50
0
56.6
90
0.12
.12
02.34
000.000

 * <p>
 * Sample Output
 * <p>
 * 90
 * 56.6
 * 50
 * 02.34
 * 0.12
 * .12
 * 0
 * 000.000
 * -100
 */