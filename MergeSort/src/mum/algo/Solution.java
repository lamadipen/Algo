package mum.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dipen on 2/22/2017.
 */
public class Solution {



    public static void main(String[] args)
    {
        int[] arr = {3,11,2,9,1,5};
        mergeSort(arr,0,arr.length-1);

        List test = new ArrayList<Integer>();

    }

    public static void mergeSort(int [] arr,int begin, int end)
    {
        //System.out.println(begin + " "+end);
        if(begin >= end)
            return;

        int mid = (begin+end)/2;
        //System.out.println(mid);
        mergeSort(arr,begin,mid);
        mergeSort(arr,mid+1,end);
        mergeHalves(arr,begin,end);
    }

    public static void mergeHalves(int arr[],int begin,int end)
    {
        int[] tempArr = new int[arr.length];
        int leftIndex =0;
        int leftEnd = (begin+end)/2;
        int rightIndex =leftEnd+1;
        int rightEnd = end;
        int size=rightEnd-leftIndex+1;
        int index = 0;

        while (leftIndex <= leftEnd && rightIndex <= rightEnd)
        {
            if(arr[leftIndex] <arr[rightIndex])
            {
                tempArr[index] = arr[leftIndex];
                leftIndex++;
            }
            else
            {
                tempArr[index] = arr[rightIndex];
                rightIndex++;
            }
            index++;
        }

        System.arraycopy(arr,leftIndex,tempArr,index,leftEnd-leftIndex+1);
        System.arraycopy(arr,rightIndex,tempArr,index,rightEnd-rightIndex+1);
        //System.arraycopy(tempArr,begin,arr,begin,size);
        System.out.println(Arrays.toString(tempArr));
    }

}
