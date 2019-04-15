package com.dp.hrank;

import java.util.Scanner;

public class JavaSubstringComparisons {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));

    }

    public static String getSmallestAndLargest(String str, int k){
        String smallest = "";
        String largest = "";

        smallest = str.substring(0,k);

        for(int i = 0; i < (str.length()+1 - k); i++){
            String subStr = str.substring(i,i+k);
            if (str.compareTo(subStr) < 0) {
                smallest = subStr;
            }
            if(str.compareTo(subStr) > 0){
                largest = subStr;
            }

        }

        return  smallest + " " + largest;
    }
}

/**
 Given a string, , and an integer, , complete the function so that it finds the lexicographically smallest and largest substrings of length .

 Input Format

 The first line contains a string denoting .
 The second line contains an integer denoting .

 Constraints

 consists of English alphabetic letters only (i.e., [a-zA-Z]).
 Output Format

 Return the respective lexicographically smallest and largest substrings as a single newline-separated string.

 Sample Input 0

 welcometojava
 3
 Sample Output 0

 ava
 wel
 Explanation 0

 String  has the following lexicographically-ordered substrings of length :

 We then return the first (lexicographically smallest) substring and the last (lexicographically largest) substring as two newline-separated values (i.e., ava\nwel).

 The stub code in the editor then prints ava as our first line of output and wel as our second line of output.
 */