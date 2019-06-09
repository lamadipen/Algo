package com.dp.hrank.java;

import java.util.Scanner;

public class JavaSubarray {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        int negative = 0;

        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();

        }

        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum = array[j]+ sum;
                if (sum < 0) {
                    System.out.println(array[i] + " " + array[j]);
                    System.out.println("Sum :" +sum);
                    negative++;
                }
            }
        }

        System.out.println("Negative subarray" + negative);

        int count=0;
        for(int j=0;j<length;j++){
            int sum=0;
            for(int k=j;k<length;k++){
                sum=array[k]+sum;
                if(sum<0){
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}

/*

Input
5
1 -2 4 -5 1

*/
