package com.cdk.coursera.algorithms.part1;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnionFind {
    static int size = 10000000;
    static int[] nodes;
    //0 1 2 3 4 5 6
    //0 1 1 3 4 5 6
    //0 1 1 3 1 5 6

    @BeforeClass
    public static void setup() {
        nodes = new int[size];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }
    }

    public void union(int pointA, int pointB) {
        int pointAid = nodes[pointA];
        int pointBid = nodes[pointB];

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == pointAid) nodes[i] = pointBid;
        }

    }
    public boolean connected(int pointA, int pointB) {
        return nodes[pointA] == nodes[pointB];
    }

    @Test
    public void unionFindTest() {
        Assert.assertFalse(connected(1, 2));
        union(1, 2);
        Assert.assertTrue(connected(1, 2));
        union(1, 4);
        Assert.assertTrue(connected(1, 4));
        Assert.assertTrue(connected(4, 2));
    }

    @Test
    public void unionFindHighFrequencyTest() {
        int max = 100000;
        int min = 0;
        int randomNumber = (int) Math.random() * ((max - min) + 1) + min;
        for (int i = 0; i < max; i++) {
            union(i, randomNumber);
        }

        Assert.assertTrue(connected(50, 100));
        Assert.assertTrue(connected(4, 2));
    }


    /*================ Quick Union  =================*/
    public void unionQuick(int pointA, int pointB) {
        int pointAid = root(pointA);
        int pointBid = root(pointB);
        nodes[pointBid] = pointAid;

    }

    public boolean quickConnected(int pointA, int pointB){
        return root(pointA) == root(pointB);
    }

    private int root(int point) {
        while (point != nodes[point]) {
            point = nodes[point];
        }
        return point;
    }

    @Test
    public void unionQuickFindHighFrequencyTest() {
        int max = 100000;
        int min = 0;
        int randomNumber = (int) Math.random() * ((max - min) + 1) + min;
        for (int i = 0; i < max; i++) {
            unionQuick(i, randomNumber);
        }

        Assert.assertTrue(quickConnected(50, 100));
        Assert.assertTrue(quickConnected(4, 2));
    }
}
