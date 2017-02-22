package mum.algo;

import java.util.Arrays;

public class Main {
    public static int[] arr = {3,11,2,9,1,5};

    public static void main(String[] args) {
	// write your code here
        sortSelf();
    }

    public static void sortSelf()
    {
        int minValue,minindex=0;
        for(int i=0;i<arr.length;i++)
        {
            minindex=i;
            minValue = arr[i];

            for (int j =i;j<arr.length;j++)
            {
                if(arr[j] < minValue){
                    minValue = arr[j];
                    minindex =j;
                }
            }
            if(minValue <arr[i])
            {
                int temp = arr[i];
                arr[i] = arr[minindex];
                arr[minindex] =temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int array[],int i,int j)
    {
        int temp=arr[i];
        arr[i]  = arr[j];
        arr[j] = temp;
    }

}
