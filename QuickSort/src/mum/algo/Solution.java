package mum.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        //int[] arr = {3,11,2,9,1,5};
        int [] arr = arrayFromInput();
        quickSort(arr);
        //System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] array){
        quickSort(array,0,array.length-1);
    }

    public static void quickSort(int [] array,int left,int right)
    {
        if(left >= right)
        {
            return;
        }

        int pivot = array[(left+right)/2];
        int index = partation(array,left,right,pivot);
        System.out.println(Arrays.toString(array));
        quickSort(array,left,index-1);
        quickSort(array,index,right);


    }

    private static int partation(int[] array, int left, int right, int pivot) {
        while(left < right)
        {
            while(array[left]<pivot)
            {
                left++;
            }
            while(array[right]>pivot)
            {
                right--;
            }
            if(left <= right){
                swap(array, left, right);
                left++;
                right--;
            }

        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;

    }

    public static int [] arrayFromInput()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] array = new int[n];

        for (int i = 0; i < n; i++) {

            array[i] = in.nextInt();
        }

        return array;
    }


}
