package hrank.HeapsFindtheRunningMedian;

/**
 * Created by dipen on 6/3/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        double [] medians = new double[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();

        }
        medians =getMedians(a);

        Arrays.stream(medians).forEach(median -> System.out.println(median));
    }

 /*   public static double getMedians(int[] array)
    {
      *//* Way implementing comparator
        PriorityQueue<Integer> low = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        });*//*
        //MAX heap
        PriorityQueue<Integer> low = new PriorityQueue<>(Comparator.reverseOrder());
        //MIN Heap
        PriorityQueue<Integer> high = new PriorityQueue<Integer>();

        double medians = 0;

        for(int i=0; i < array.length; i++)
        {
            int number = array[i];
            addNumber(number,low,high);
            rebalance(low,high);
            medians = getMedian(low,high);
        }
        return  medians;
    }*/


    public static double[] getMedians(int[] array)
    {
      // Way implementing comparator
        /*
        PriorityQueue<Integer> low = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        });*/
        //MAX heap
        PriorityQueue<Integer> low = new PriorityQueue<>(Comparator.reverseOrder());
        //MIN Heap
        PriorityQueue<Integer> high = new PriorityQueue<Integer>();

        double [] medians = new double[array.length];

        for(int i=0; i < array.length; i++)
        {
            int number = array[i];
            addNumber(number,low,high);
            rebalance(low,high);
            medians[i] = getMedian(low,high);
        }
        return  medians;
    }



    private static void addNumber(int number, PriorityQueue<Integer> low, PriorityQueue<Integer> high) {

        if(low.size() == 0 || low.peek() > number)
        {
            low.add(number);
        }
        else
        {
            high.add(number);
        }
    }


    private static void rebalance(PriorityQueue<Integer> low, PriorityQueue<Integer> high) {
        PriorityQueue<Integer> biggerHeap = low.size()  > high.size()?low:high;
        PriorityQueue<Integer> smallerHeap = low.size() > high.size()? high: low;

        if(biggerHeap.size() - smallerHeap.size() >= 2)
        {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static double getMedian(PriorityQueue<Integer> low, PriorityQueue<Integer> high) {
        PriorityQueue<Integer> biggerHeap = low.size()  > high.size()?low:high;
        PriorityQueue<Integer> smallerHeap = low.size() > high.size()? high:low;

        if(biggerHeap.size() == smallerHeap.size())
        {
            return ((double)biggerHeap.peek() + smallerHeap.peek())/2;
        }
        else
        {
            return  biggerHeap.peek();
        }
    }

}

/** Input
 6
 12
 4
 5
 3
 8
 7
 */

/* output
12.0
8.0
5.0
4.5
5.0
6.0
 */


