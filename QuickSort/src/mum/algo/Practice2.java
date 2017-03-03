package mum.algo;

import java.util.Arrays;

/**
 * Created by dipen on 2/23/2017.
 *
 */
public class Practice2 {

    public static void main(String  [] args)
    {
        int[] arr = {9,7,5,1,3,2};
        quickSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public  static void quickSort(int [] arr,int start,int end)
    {
        if(end <= start)
            return;
        int index =partation(arr,0,arr.length-1);
        //quickSort(arr,index+1,arr.length-1);
        quickSort(arr,0,index);
        //
    }

    public static int partation(int []array,int start, int end)
    {
        int pivot = array[end];
        int pIndex = start;

        for(int i=start;i<end-1;i++)
        {
            if(array[i]<= pivot)
            {
                swap(array,i,pIndex);
                pIndex++;
                System.out.println(pIndex+ "  " +end);
                System.out.println(Arrays.toString(array));
            }
        }
        swap(array,pIndex,end);

        return pIndex;
    }

    private static void swap(int[] array,int start, int end) {
            int temp= array[start];
            array[start]= array[end];
            array[end] =temp;
    }


}
