package com.dp.cci.customdatastructure;

public class CustomSet {
    private int size = 0;
    private Object[] array;

    public CustomSet() {
        array = new Object[2];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object item) {
        if (contains(item)) {
            return;
        }
        if (size == array.length) {
            resize();
        }
        array[size] = item;
        size++;
    }

    private void resize() {
        Object[] temp = new Object[size * 2];
        System.arraycopy(array, 0, temp, 0, size);
        array = temp;
    }

    public int getSize() {
        return size;
    }

    public boolean contains(Object item) {
        return getIndex(item) != -1;
    }

    private int getIndex(Object item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(String item) {
        int index = getIndex(item);
        if (array[index].equals(item)) {
            array[index] = array[size - 1];
            array[size - 1] = null;
            size--;
        }

    }
}
