package com.dp.hrank.interviewPreperationKit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SockMarchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
       // return sockMerchantMapSolution(n, ar);
       // return sockMarchant(n, ar);
        return sockMarchantArray(n, ar);

    }

    private static int sockMarchantArray(int n, int[] ar) {
        int[] pairsToSell = new int[n];
        int countToSell = 0;
        for(int i =0; i < n; i++){
            int ind = ar[i] % n;
            pairsToSell[ind] +=1;
            if (pairsToSell[ind] == 2) {
                countToSell++;
                pairsToSell[ind] = 0;
            }
        }
        return countToSell;
    }

    private static int sockMarchant(int n, int[] ar) {
        Set<Integer> colors = new HashSet<>();
        int pairs = 0;

        for(int i =0; i < n; i++){
            if(!colors.contains(ar[i])){
                colors.add(ar[i]);
            }else{
                pairs++;
                colors.remove(ar[i]);
            }
        }
        return pairs;
    }

    private static int sockMerchantMapSolution(int n, int[] ar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairCount = 0;
        for (int i = 0; i < n; i++) {
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(ar[i],1);
            }
        }

        for (Map.Entry entry: map.entrySet()) {
            Integer value = map.get(entry.getKey());
            pairCount +=  value/2;
        }
        return pairCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
/**
 John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

 For example, there are  socks with colors . There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .

 Function Description

 Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.

 sockMerchant has the following parameter(s):

 n: the number of socks in the pile
 ar: the colors of each sock
 Input Format

 The first line contains an integer , the number of socks represented in .
 The second line contains  space-separated integers describing the colors  of the socks in the pile.

 Constraints

 where
 Output Format

 Return the total number of matching pairs of socks that John can sell.

 Sample Input

 9
 10 20 20 10 10 30 50 10 20
 Sample Output

 3
 Explanation*/