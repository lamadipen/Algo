package com.dp.hrank;

import java.util.Arrays;
import java.util.Scanner;

public class JavaAnagrams {
    static boolean isAnagram(String a, String b) {
        // Complete the function
        char[] aArrays = a.toCharArray();
        char[] bArrays = b.toCharArray();

        Arrays.sort(aArrays);
        Arrays.sort(bArrays);

        String a1 = new String(aArrays);
        String b1 = new String(bArrays);

        System.out.println(a1);
        System.out.println(a1.equals(b1));

        return a1.equalsIgnoreCase(b1);
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}


/**
 Sample Input 1

 anagramm
 marganaa
 Sample Output 1

 Not Anagrams


 Sample Input 2

 Hello
 hello
 Sample Output 2

 Anagrams

 * */