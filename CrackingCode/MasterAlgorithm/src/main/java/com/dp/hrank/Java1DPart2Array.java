package com.dp.hrank;

import java.util.Scanner;

public class Java1DPart2Array
{
    public static boolean canWin(int leap, int[] game) {
       // return iterativeSolution(leap, game);
        return isSolveable(0,leap, game);
    }

    private static boolean iterativeSolution(int leap, int[] game) {
        boolean canWin = false;
        int currentIndex = 0;
        for(int i =0; i < game.length; i++){
            if(game.length > currentIndex +1  && game[currentIndex+1] == 0){
                currentIndex++;
            }
        }
        if(currentIndex == game.length -1){
            canWin = true;
        }
        if(currentIndex + leap >= game.length){
            canWin = true;
        }

        return canWin;
    }


    public static boolean isSolveable(int index, int leap, int[] game){
        /*Base case*/
        if(index < 0 || game[index] == 1){
            return false;
        }
        if(index == game.length -1 || (index + leap) >= game.length){
            return true;
        }

        //marks as visited
        game[index] = 1;

        //Recursive cases
        return isSolveable(index - 1, leap, game)
                || isSolveable(index + 1, leap, game)
                || isSolveable(index + leap,leap, game);
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

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }

}
/**

 Let's play a game on an array! You're standing at index  of an -element array named . From some index  (where ), you can perform one of the following moves:

 Move Backward: If cell  exists and contains a , you can walk back to cell .
 Move Forward:
 If cell  contains a zero, you can walk to cell .
 If cell  contains a zero, you can jump to cell .
 If you're standing in cell  or the value of , you can walk or jump off the end of the array and win the game.
 In other words, you can move from index  to index , , or  as long as the destination index is a cell containing a . If the destination index is greater than , you win the game.

 Given  and , complete the function in the editor below so that it returns true if you can win the game (or false if you cannot).

 Input Format

 The first line contains an integer, , denoting the number of queries (i.e., function calls).
 The  subsequent lines describe each query over two lines:

 The first line contains two space-separated integers describing the respective values of  and .
 The second line contains  space-separated binary integers (i.e., zeroes and ones) describing the respective values of .
 Constraints

 It is guaranteed that the value of  is always .
 Output Format

 Return true if you can win the game; otherwise, return false.

 Sample Input

 4
 5 3
 0 0 0 0 0
 6 5
 0 0 0 1 1 1
 6 3
 0 0 1 1 1 0
 3 1
 0 1 0
 Sample Output

 YES
 YES
 NO
 NO
 Explanation

 We perform the following  queries:

 For  and , we can walk and/or jump to the end of the array because every cell contains a . Because we can win, we return true.
 For  and , we can walk to index  and then jump  units to the end of the array. Because we can win, we return true.
 For  and , there is no way for us to get past the three consecutive ones. Because we cannot win, we return false.
 For  and , there is no way for us to get past the one at index . Because we cannot win, we return false.


 */