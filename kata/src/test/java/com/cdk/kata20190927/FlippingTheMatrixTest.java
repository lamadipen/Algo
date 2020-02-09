package com.cdk.kata20190927;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlippingTheMatrixTest {
    //https://www.hackerrank.com/challenges/flipping-the-matrix/problem

    @Test
    public void shouldGetQuadrantScroreFor2X() {
        Assert.assertEquals(1, getScore(1, new int[][]{
                new int[] {1, 2},
                new int[] {3, 4}
        }));
        Assert.assertEquals(4, getScore(1, new int[][]{
                new int[] {4, 2},
                new int[] {3, 1}
        }));
        Assert.assertEquals(112 + 42 + 56 + 125, getScore(2, new int[][]{
                new int[] {112, 42, 83, 119},
                new int[] {56, 125, 56, 49},
                new int[] {15, 78, 101, 43},
                new int[] {62, 98, 114, 108},
        }));
    }

    private int getScore(int n, int[][] input) {
        int score = 0;
        for (int i = 0; i < n; i++) {
            for (int j =0 ; j < n; j++){
                score += input[i][j];
            }
        }
        return score;
    }

    @Test
    public void shouldGetMaxElementIn2x2Matrix() {
        int[][] input = {
                new int[] {1, 2},
                new int[] {3, 4}
        };
        int max = flipMatrix(input);
        Assert.assertEquals(4, max);
    }

    private int flipMatrix(int[][] input) {
        int max = getScore(1,input);
        flipRow(0, input);
        return 0;
    }

    @Test
    public void shouldFlipRow() {
        int[][] input = {{0, 1}};
        flipRow(0, input);
        Assert.assertEquals(1, input[0][0]);
        Assert.assertEquals(0, input[0][1]);
    }

    private void flipRow(int row, int[][] input) {
        int i = 0;
        int j = input[row].length - 1;
        while (i < j) {
            int temp = input[row][i];
            input[row][i] = input[row][j];
            input[row][j] = temp;
            i++;
            j--;
        }

    }

}