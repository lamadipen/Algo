package mum.algo;

/**
 * Created by dipen on 2/23/2017.
 */

public class CoolSolution {

    public static void sort(int[] arr) {

        int arrayLength = arr.length;
        if (arrayLength < 2)
            return;

        int pivot = arrayLength / 2;
        int[] left = new int[pivot];
        int[] right = new int[arrayLength - pivot];

        for (int i = 0; i < pivot; i++) {
            left[i] = arr[i];
        }

        for (int j = pivot; j < arrayLength; j++) {
            right[j - pivot] = arr[j];
        }

        sort(left);
        sort(right);
        merge(left, right, arr);
    }

    private static void merge(int[] left, int[] right, int[] arr) {

        int leftLength = left.length;
        int rightLength = right.length;

        int i = 0, j = 0, k= 0;

        while(i < leftLength && j < rightLength){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < leftLength){
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j < rightLength){
            arr[k] = right[j];
            j
                    ++;
            k++;
        }
    }

}