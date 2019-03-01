package com.dp.cci.customdatastructure;

public class CustomSet {


    private int size =0;
    private int[] arr = new int[2];

    public boolean isEmpty() {
        return  size > 0 ? false:true ;
    }

    public int getSize() {
        return size;
    }

    public void add(int i) {
        if(size >= arr.length){
            resize();
        }
        if (contains(i)) {
            return;
        }
        arr[size] = i;
        size++;
    }

    private void resize() {
        int[] tempArr = new int[size*2];
        System.arraycopy(arr,0,tempArr,0,size);
        arr = tempArr;
    }

    public void remove(int i) {
        int index = getIndexOf(i);
        if(index > -1){
            arr[index] = arr[size];
            size--;
        }
    }

    public boolean contains(int i) {
        return getIndexOf(i) > -1 ? true : false;
    }

    private int getIndexOf(int i) {
        for(int j=0; j < size; j++){
            if(arr[j] == i){
                return j;
            }
        }
        return -1;
    }
}
