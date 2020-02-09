package com.cdk.kata20191008;

import org.junit.Assert;
import org.junit.Test;

public class MergeSort {

    @Test
    public void mergeSort() {
        int[] nullArray = null;
        int[] oneItem= new int[]{1};
        int[] twoItems= new int[]{2,1};
        int[] threeItems= new int[]{2,1,3};

        int[] twoSorted= new int[]{1,2};
        int[] threeSorted= new int[]{1,2,3};


        mergeSort(nullArray,0,0);
        Assert.assertNull(nullArray);

        mergeSort(oneItem,0,oneItem.length-1);
        Assert.assertArrayEquals(oneItem ,oneItem);


        mergeSort(twoItems,0,twoItems.length-1);
        Assert.assertArrayEquals(twoSorted ,twoItems);


        mergeSort(threeItems,0,threeItems.length-1);
        Assert.assertArrayEquals(threeSorted ,threeItems);
    }

    private void mergeSort(int[] arr, int start, int end) {
        if(null == arr){
            return;
        }
        if(arr.length < 2){
            return;
        }
        if(start < end){
            int mid= (start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merger(arr, start, mid, end);
        }


    }

    private void merger(int[] arr, int start, int mid, int end) {
        int i= start;
        int j= mid+1;
        int[] temp = new int[end-start+1];
        int tempIndex = 0;

        while(start <= i && j <= end){
            if(arr[i] < arr[j]){
                temp[tempIndex++] = arr[i];
                i++;
            }else if(arr[j] < arr[i]){
                temp[tempIndex++] = arr[j];
                j++;
            }
        }

        if(i > mid){
            temp[tempIndex++] = arr[j];
            j++;
        }
        if(j > end){
            temp[tempIndex++] = arr[i];
            i++;
        }


        for(int k = start; k < tempIndex; k++){
            arr[k] = temp[k];
        }
    }

}
