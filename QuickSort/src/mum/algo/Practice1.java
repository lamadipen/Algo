package mum.algo;

/**
 * Created by dipen on 2/23/2017.
 * see the youtube link
 * https://www.youtube.com/watch?v=y_G9BkAm6B8
 */
public class Practice1 {
    public static void main(String  [] args)
    {

    }

    public static void quickSort(int [] array, int len)
    {
        int arraySize = len;
        if(arraySize < 2)
            return;
        int randomIndex= (int) (Math.random()%arraySize);
        int pivot = array[randomIndex];
        int begin=0;
        int end=arraySize-1;

        while(begin <end)
        {
            while (array[begin]< pivot)
            {
                begin++;
            }
            while (array[end]>pivot)
            {
                end--;
            }
            swap(array,begin,end);
        }

        quickSort(array,begin);
        quickSort(array,arraySize-end-1);
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;

    }
}

