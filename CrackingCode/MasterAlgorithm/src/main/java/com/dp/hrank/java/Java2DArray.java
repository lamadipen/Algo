package com.dp.hrank.java;

import java.util.Scanner;

public class Java2DArray {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = sc.nextLine().split(" ");
            sc.skip("(\\r\\n|[\\n\\r\\u2028\\u2029\\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;

            }
        }


        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                // if(i > 3 || j > 3) continue;
                if (i < 4 && j < 4) {
                    int glassSum =
                            arr[j][i]   + arr[j][i+1]   + arr[j][i+2]
                                    + arr[j+1][i+1] +
                                    arr[j+2][i] + arr[j+2][i+1] + arr[j+2][i+2];

                    if(glassSum > maxSum) maxSum = glassSum;

                }


            }
        }

        System.out.println(maxSum);
        sc.close();
    }


}


/*

You are given a  2D array. An hourglass in an array is a portion shaped like this:

a b c
  d
e f g
For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:

1 1 1     1 1 0     1 0 0
  1         0         0
1 1 1     1 1 0     1 0 0
The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.

In this problem you have to print the largest sum among all the hourglasses in the array.

Input Format

There will be exactly  lines, each containing  integers seperated by spaces. Each integer will be between  and  inclusive.

Output Format

Print the answer to this problem on a single line.

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output

19
Explanation

The hourglass which has the largest sum is:

2 4 4
  2
1 2 4
*/