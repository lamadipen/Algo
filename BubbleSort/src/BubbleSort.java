import java.time.Clock;
import java.util.Arrays;

/**
 * Created by dipen on 2/17/2017.
 */
public class BubbleSort {

    public static int[] arr = {3,11,2,9,1,5};
    public static void main(String[] args)
    {
         //   sort();
        sortHackerRank();
        System.out.println(Arrays.toString(arr));
    }

    public static void sort()
    {
        long startTime = System.currentTimeMillis();

        int counter=0;
        for (int i=1;i<arr.length;i++)
        {
            for(int j=0; j < arr.length-1;j++)
            {
                if(arr[i] < arr[j])
                {
                    int temp=arr[i];
                    arr[i]  = arr[j];
                    arr[j] = temp;
                    System.out.println(arr[j]+ " Switching "+ arr[i]);
                }

            }

        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Time taken "+elapsedTime+ " ms");
    }

    public static void sortHackerRank()
    {
        long startTime = System.currentTimeMillis();

        boolean isSorted= false;
        int lastUnsortedArray=arr.length -1;
        while(!isSorted)
        {
            isSorted =true;
            for(int i =0; i < lastUnsortedArray;i++)
            {
                if(arr[i] >arr[i+1])
                {
                    swap(arr,i,i+1);
                    isSorted = false;
                }
            }
            lastUnsortedArray--;
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Time taken "+elapsedTime+ " ms");
    }

    public static void swap(int array[],int i,int j)
    {
        int temp=arr[i];
        arr[i]  = arr[j];
        arr[j] = temp;
    }
}
