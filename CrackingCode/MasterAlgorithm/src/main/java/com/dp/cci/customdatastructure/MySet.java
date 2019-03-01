package com.dp.cci.customdatastructure;

public class MySet {
    private int size = 0;
    private Object[] array = new Object[2];

    public boolean isEmpty() {
        return size > 0 ? false : true;
    }

    public int getSize() {
        return size;
    }

    public void add(Object item) {
        if (array.length <= size) {
            resize();
        }
        if (getIndex(item) > -1) {
            return;
        }
        array[size] = item;
        size++;
    }

    private void resize() {
        Object[] tempArray = new Object[size * 2];
        System.arraycopy(array, 0, tempArray, 0, size);
        array = tempArray;
    }

    public boolean contains(Object item) {
        return getIndex(item) > -1? true : false;

    }

    public void remove(Object item) {
        Integer index = getIndex(item);
        if (index > -1) {
            array[index] = array[size];
            array[size] = null;
            size--;
        } else {
            throw new RuntimeException("No Matching Element found");
        }
    }

    private Integer getIndex(Object item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
}
