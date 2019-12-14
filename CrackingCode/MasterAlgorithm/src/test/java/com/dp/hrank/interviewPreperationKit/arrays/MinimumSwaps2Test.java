package com.dp.hrank.interviewPreperationKit.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MinimumSwaps2Test {

    @Test
    public void minimumSwapsTest() {
        int [] arr = new int[]{7,1,3,2,4,5,6} ;
        int [] oneElement = new int[]{7} ;
        int [] twoElement = new int[]{7,1} ;
        int [] threeElement = new int[]{2,7,1} ;

//        assertEquals(0, minimumSwaps(oneElement));
//        assertEquals(1, minimumSwaps(twoElement));
//        assertEquals(2, minimumSwaps(threeElement));
        mergeSort(arr,0,arr.length-1);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7}, arr);
    }

    private int minimumSwaps(int[] arr) {
        if(arr.length == 1)
            return 0;
        mergeSort(arr,0,arr.length-1);
        return 1;
    }

    private void mergeSort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int p = start ,q = mid+1;

        int[] temp = new int[end-start+1];
        int k=0;


        //https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/tutorial/
    }


}