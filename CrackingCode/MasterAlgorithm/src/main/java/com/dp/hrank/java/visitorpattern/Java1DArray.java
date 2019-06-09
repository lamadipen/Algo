package com.dp.hrank.java.visitorpattern;

import java.util.Scanner;

public class Java1DArray {

    public static boolean canWin(int leap, int[] game) {
        int length = game.length;
        int index = 0;

        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;

        for (int i = 0; i < length + leap; i++) {

            if(index+ leap >= length || index > length -1){
                return true;
            }

            if (index < length && game[index + 1] == 0) {
                index += 1;
            }
//            if (index > 0 && game[index - 1] == 0) {
//                index -= 1;
//            }
            if((index + leap) < length && game[index+leap] == 0){
                index += leap;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}

/**
 * Let's play a game on an array! You're standing at index  of an -element array named . From some index  (where ), you can perform one of the following moves:
 * <p>
 * Move Backward: If cell  exists and contains a , you can walk back to cell .
 * Move Forward:
 * If cell  contains a zero, you can walk to cell .
 * If cell  contains a zero, you can jump to cell .
 * If you're standing in cell  or the value of , you can walk or jump off the end of the array and win the game.
 * In other words, you can move from index  to index , , or  as long as the destination index is a cell containing a . If the destination index is greater than , you win the game.
 * <p>
 * Given  and , complete the function in the editor below so that it returns true if you can win the game (or false if you cannot).
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, , denoting the number of queries (i.e., function calls).
 * The  subsequent lines describe each query over two lines:
 * <p>
 * The first line contains two space-separated integers describing the respective values of  and .
 * The second line contains  space-separated binary integers (i.e., zeroes and ones) describing the respective values of .
 * Constraints
 * <p>
 * It is guaranteed that the value of  is always .
 * Output Format
 * <p>
 * Return true if you can win the game; otherwise, return false.
 * <p>
 * Sample Input
 * <p>
 6
 5 3
 0 0 0 0 0
 6 5
 0 0 0 1 1 1
 6 3
 0 0 1 1 1 0
 3 1
 0 1 0
 5 4
 0 0 1 2 3
 11 4
 0 0 0 1 0 1 0 1 1 1 0
 18 4
 0 0 0 1 0 1 0 1 0 1 0 1 0 1 0 1 1 1
 1
 17 3
 0 0 0 1 0 1 0 1 0 1 0 1 0 1 0 1 1


 * Sample Output
 * <p>
 * YES
 * YES
 * NO
 * NO
 * Explanation
 * <p>
 * We perform the following  queries:
 * <p>
 * For  and , we can walk and/or jump to the end of the array because every cell contains a . Because we can win, we return true.
 * For  and , we can walk to index  and then jump  units to the end of the array. Because we can win, we return true.
 * For  and , there is no way for us to get past the three consecutive ones. Because we cannot win, we return false.
 * For  and , there is no way for us to get past the one at index . Because we cannot win, we return false.
 */