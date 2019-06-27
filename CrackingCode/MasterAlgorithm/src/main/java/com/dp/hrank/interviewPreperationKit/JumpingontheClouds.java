package com.dp.hrank.interviewPreperationKit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JumpingontheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
     return 0;

    }

    static int jump(int[]c, int index){
        int destination = c.length - 1;

        if(index + 1 == destination  || index == destination +2){
        }
        return 1;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


/**
 Emma is playing a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus  or . She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud. It is always possible to win the game.

 For each game, Emma will get an array of clouds numbered  if they are safe or  if they must be avoided. For example,  indexed from . The number on each cloud is its index in the list so she must avoid the clouds at indexes  and . She could follow the following two paths:  or . The first path takes jumps while the second takes .

 Function Description

 Complete the jumpingOnClouds function in the editor below. It should return the minimum number of jumps required, as an integer.

 jumpingOnClouds has the following parameter(s):

 c: an array of binary integers
 Input Format

 The first line contains an integer , the total number of clouds. The second line contains  space-separated binary integers describing clouds  where .

 Constraints

 Output Format

 Print the minimum number of jumps needed to win the game.

 Sample Input 0

 7
 0 0 1 0 0 1 0
 Sample Output 0

 4
 Explanation 0:





 */