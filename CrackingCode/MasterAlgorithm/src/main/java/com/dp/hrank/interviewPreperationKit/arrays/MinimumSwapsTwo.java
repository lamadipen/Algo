package com.dp.hrank.interviewPreperationKit.arrays;

import java.io.IOException;
import java.util.Scanner;

public class MinimumSwapsTwo {
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int fistIndex = 0;
        int secondIndex = 1;
        int count = 0;
        while (fistIndex < arr.length - 1) {
            if (arr[fistIndex] > arr[secondIndex]) {
                swap(arr, fistIndex, secondIndex);
                count++;
            }
            if (secondIndex == arr.length - 1) {
                fistIndex = fistIndex + 1;
                secondIndex = fistIndex;
            }
            secondIndex++;
        }

        return count;
    }

    private static void swap(int[] arr, int fistIndex, int secondIndex) {
        int temp = arr[fistIndex];
        arr[fistIndex] = arr[secondIndex];
        arr[secondIndex] = temp;


    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//          int[] arr ={4, 3, 1, 2};
//          System.out.println(minimumSwaps(arr));

        int[] arr = {5, 1, 4, 2};
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