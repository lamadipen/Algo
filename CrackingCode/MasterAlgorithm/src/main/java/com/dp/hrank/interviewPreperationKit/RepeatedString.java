package com.dp.hrank.interviewPreperationKit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long aCount = 0;
        long count = 0;
        if(s.length() == 1){
            return s.equals("a")?n:0;
        }

        for(int i= 0; i < s.length(); i++){
            if(s.charAt(i) == 'a')
                aCount++;
        }

        count = (int) n/s.length() * aCount;
        long rem = (int)n % s.length();

        for(int i=0; i < rem; i++){
            if(s.charAt(i) == 'a')
                count++;
        }

        return count;
    }
}

