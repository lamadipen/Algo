package com.cdk.arrayandstrings;

import org.junit.Assert;
import org.junit.Test;
import java.util.Stack;

public class ReverseArray {

    @Test
    public void reverseUsingStack() {
        int[] array = new int[]{1, 2, 4, 5, 7, 9,11};
        Stack<Integer> tempStack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            tempStack.add(array[i]);
        }
        int[] tempArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = tempStack.pop();
        }
        Assert.assertArrayEquals(new int[]{11,9,7,5,4,2,1},tempArray);
    }

    @Test
    public void reverseUsingTwoPointer() {
        int[] array = new int[]{1, 2, 4, 5, 7, 9,11};
        int begin =0;
        int end = array.length - 1;

        while (begin < end){
            swap(array, begin, end);
            begin++;
            end--;
        }
        Assert.assertArrayEquals(new int[]{11,9,7,5,4,2,1},array);
    }

    public void swap(int[] array, int begin, int end) {
        int temp = array[begin];
        array[begin] = array[end];
        array[end] = temp;
    }

    @Test
    public void reverseArrayForLoopFromEnd() {
        int[] array = new int[]{1, 2, 4, 5, 7, 9,11};
        int tempIndex =0;
        int[] tempArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            tempArray[tempIndex++] = array[i];
        }
        Assert.assertArrayEquals(new int[]{11,9,7,5,4,2,1},tempArray);
    }
}
