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

    static boolean isAnagramByArray(String a,String b) {
        if(a == null || b == null || a.length() != b.length())return false;

        int[] charArray = new int[Character.MAX_VALUE]; //ASCII character max value could be used as 128

        for (int i = 0; i < a.length(); i++) {
            int aIndex = a.charAt(i);
            charArray[aIndex]++;
            int bIndex = b.charAt(i);
            charArray[bIndex]--;
        }

        for(int i = 0; i < a.length(); i++){
            int aIndex = a.charAt(i);
            if(charArray[aIndex] > 0 || charArray[aIndex] < 0)return false;
        }
        return true;
    }

    static boolean isAnagramArrayOptimized(String a, String b) {
        if(a == null || b == null || a.length() != b.length())return false;

        int[] charArray = new int[Character.MAX_VALUE];
        int sum =  0;
        for(int i = 0; i < a.length(); i++ ){
            int aIndex = a.charAt(i);
            sum += ++charArray[aIndex] <= 0?-1:1;
            sum += --charArray[b.charAt(i)] >= 0? -1:1;
        }
        return sum == 0;
    }


    /*
    * SortedMap<Integer, Character> s = new TreeMap<>();
    for(int i=0;i<a.length();i++){
        s.put(i, a.charAt(i));
    }
    SortedMap<Integer, Character> s1 = new TreeMap<>();
    for(int i=0;i<b.length();i++){
        s1.put(i, a.charAt(i));
    }
    System.out.println(s1.equals(s));
*/

    /*static boolean isAnagram(String a, String b) {
    if(a.length() != b.length())
        return false;
    a= a.toLowerCase();
    b= b.toLowerCase();
    int index;
    for(int i=0;i<a.length();i++)
    {
        index =b.indexOf(a.charAt(i));
        if(index==-1)
            return false;
        else
        {
            //this removes b[index]
            b = b.substring(0,index) + b.substring(index+1);
        }
    }
    return true;
}*/
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        //boolean ret = isAnagram(a, b);
        boolean ret = isAnagramByArray(a, b);
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