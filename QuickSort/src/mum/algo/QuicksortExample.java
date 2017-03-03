package mum.algo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dipen on 2/25/2017.
 */
public class QuicksortExample {

    public static void main(String [] args)
    {
        int[] array =arrayFromInput();
        //int[] array =getArray(10);
        printArray(array);
        quickSort(array,0,array.length-1);
        //printArray(array);

    }

    public static void quickSort(int [] array,int begin,int end)
    {
        //base case
        if(begin >= end)
            return;
        int index = partation(array,begin,end);
        printArray(array);
        quickSort(array,begin,index-1);
        quickSort(array,index,end);
    }

    public static int partation(int [] array,int begin,int end)
    {
        int pivot = array[(begin+end)/2];
        System.out.println(pivot);
        while(begin <= end){
            while (array[begin]<pivot){
              begin++;
            }
            while(array[end] > pivot)
            {
               end--;
            }

            if(begin<=end)
            {
                swap(array,begin,end);
                begin++;
                end--;
            }
        }
        //System.out.println(begin +" "+end);
        return begin;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;

    }


    public static int[] getArray(int size)
    {
        int [] array = new int[size];
        for(int i=0; i < size;i++){
            array[i] = (int)(Math.random()*100);
            //System.out.println(array[i]);
        }
        //printArray(array);
        return array;
    }

    public static void printArray(int [] array)
    {
        System.out.println(Arrays.toString(array));
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
