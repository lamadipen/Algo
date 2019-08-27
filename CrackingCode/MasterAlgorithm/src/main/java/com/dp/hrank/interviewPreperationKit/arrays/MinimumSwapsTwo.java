package com.dp.hrank.interviewPreperationKit.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinimumSwapsTwo {
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {


        return 0;
    }




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
          int[] arr ={4, 3, 1, 2};
          System.out.println(minimumSwaps(arr));

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }
//
//        int res = minimumSwaps(arr);
//
//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
/** https://www.hackerrank.com/challenges/minimum-swaps-2/problem

 You are given an unordered array consisting of consecutive integers
 [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any
 two elements. You need to find the minimum number of swaps required to
 sort the array in ascending order.

 Input
 4
 4 3 1 2
 output
 3
 * */