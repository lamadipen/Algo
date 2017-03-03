package mum.algo;

import java.util.Arrays;

public class MergeSort {
    public static int[] arr = {3,11,2,9,1,5};

    public static void main(String[] args) {
	// write your code here

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int []leftHalf,int []rightHalf,int []array)
    {
        int leftLen = leftHalf.length;
        int rightLen = rightHalf.length;

        int leftIndex =0;
        int rightIndex =0;
        int k=0;

        System.out.println("orginal "+Arrays.toString(array));
        System.out.println("left "+Arrays.toString(leftHalf));
        System.out.println("right "+Arrays.toString(rightHalf));
        while(leftIndex < leftLen && rightIndex < rightLen)
        {
            if(leftHalf[leftIndex] <= rightHalf[rightIndex])
            {
                array[k] = leftHalf[leftIndex];
                leftIndex++;
            }
            else
            {
                array[k] = rightHalf[rightIndex];
                rightIndex++;
            }
            k++;
        }
        while(leftIndex < leftLen)
        {
            array[k] = leftHalf[leftIndex];
            k++;
            leftIndex++;
        }
        while(rightIndex > rightLen)
        {
            array[k] = rightHalf[rightIndex];
            k++;
            rightIndex++;
        }


    }

    public static void sort(int [] array)
    {
        int arrLen = array.length;
        if(arrLen <2)
            return;
        int mid = arrLen/2;

        int[] lHalf = new int[mid];
        int[] rHalf = new int[arrLen-mid];

        for(int i=0;i<lHalf.length;i++)
        {
            lHalf[i] = array[i];
        }

        for(int i=mid;i<array.length;i++)
        {
            rHalf[i-mid] = array[i];
        }
        //System.out.println(Arrays.toString(lHalf));
        //System.out.println(Arrays.toString(rHalf));
        sort(lHalf);
        sort(rHalf);

        merge(lHalf,rHalf,array);

    }
}
