package hrank.HeapsFindtheRunningMedian;

import java.util.Arrays;

/**
 * Created by dipen on 6/1/2017.
 */
public class MinIntHeap {

    private int capacity=10;
    private int size = 0;

    int [] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex)
    {
        return 2* parentIndex +1;
    }

    private int getRightChindIndex(int parentIndex){
        return 2* parentIndex +2;
    }

    private int getParentIndex(int childIndex)
    {
        return (childIndex-1)/2;
    }

    private boolean hasLeftChild(int index)
    {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index)
    {
        return  getRightChindIndex(index) < size;
    }

    private boolean hasParent(int index)
    {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index)
    {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index)
    {
        return items[getRightChindIndex(index)];
    }

    private int parent(int index)
    {
        return items[getParentIndex(index)];
    }

    private void swap(int index1, int index2)
    {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    private void ensureExtraCapacity()
    {
        if(size == capacity)
        {
            items = Arrays.copyOf(items,capacity*2);
            capacity *= 2;
        }
    }

    public int peek()
    {
        if(size == 0 ) throw new IllegalStateException();
        return items[0];
    }

    public int poll()
    {
        if(size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item)
    {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size -1;
        while (hasParent(index) && parent(index) > items[index])
        {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index =0;

        while(hasLeftChild(index))
        {
            int smallerChildIndex = getLeftChildIndex(index);

            if(hasRightChild(index) && rightChild(index) < leftChild(index))
            {
                smallerChildIndex = getRightChindIndex(index);
            }

            if(items[index] < items[smallerChildIndex])
            {
                break;
            }
            else
            {
                swap(index,smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }



}
