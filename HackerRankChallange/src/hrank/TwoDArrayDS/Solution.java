package hrank.TwoDArrayDS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dipen on 3/1/2018.
 */
public class Solution {

    public static void main(String[] args) {

         /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int[][] myArray = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                myArray[i][j] = sc.nextInt();
            }
        }

        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int temp = myArray[i][j] + myArray[i][j + 1] + myArray[i][j + 2] + myArray[i + 1][j + 1] + myArray[i + 2][j] + myArray[i + 2][j + 1] + myArray[i + 2][j + 2];
                if (temp > sum) {
                    sum = temp;
                }
            }

            System.out.println(Arrays.toString(myArray));
        }
    }
}


/**
 input
 **/