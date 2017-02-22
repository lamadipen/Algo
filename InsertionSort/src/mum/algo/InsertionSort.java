package mum.algo;

import java.util.Arrays;

public class InsertionSort {
    public static int[] arr = {3,11,2,9,1,5};

    public static void main(String[] args) {
	// write your code here
        sort();
    }

    public static void sort()
    {
        int tempIndex=0;
        int tempValue=0;

        for(int i=1;i<arr.length;i++)
        {
            tempValue = arr[i];
            tempIndex = i;
            while(tempIndex >0 && tempValue <arr[tempIndex-1])
            {
                arr[tempIndex] = arr[tempIndex-1];
                tempIndex--;
            }
            arr[tempIndex]=tempValue;
        }
        System.out.println(Arrays.toString(arr));

    }


}
