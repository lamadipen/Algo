package com.shailesh;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomSortedArrayTest {

    @Test
    public void secnario1() {

        List<Integer> list = new ArrayList<>();
        int[] array = {6, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        int moves = Result.moves(list);

        Assert.assertEquals(1, moves);
    }

    @Test
    public void secnario2() {
        List<Integer> list = new ArrayList<>();
        int[] array = {13, 10, 21, 20};
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        int moves = Result.moves(list);

        Assert.assertEquals(1, moves);
    }

}