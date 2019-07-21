package com.dp.hrank.interviewPreperationKit.DictionariesAndHashmaps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        String longString = s1.length() >= s2.length()? s1: s2;
        String shortString = s1.length() > s2.length()? s2: s1;
        HashMap<Character, Character> charMap = new HashMap<>();

        for(int i=0; i < longString.length(); i++){
            charMap.put(longString.charAt(i), longString.charAt(i));
        }

        for (int i = 0; i < shortString.length(); i++) {
            return charMap.containsKey(shortString.charAt(i))? "YES": "NO";
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
