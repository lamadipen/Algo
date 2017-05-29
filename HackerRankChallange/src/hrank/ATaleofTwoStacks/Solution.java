package hrank.ATaleofTwoStacks;

/**
 * Created by dipen on 5/29/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {

            if(!stackOldestOnTop.empty())
            {
                return stackOldestOnTop.peek();
            }
            else if(!stackNewestOnTop.empty())
            {
                arrangeQueue();
                return stackOldestOnTop.peek();
            }
            else
            {
                return  null;
            }
        }

        public T dequeue() {

            if(!stackOldestOnTop.empty())
            {
                return stackOldestOnTop.pop();
            }else if(!stackNewestOnTop.empty())
            {
                arrangeQueue();
                return dequeue();
            }
            else
            {
                return null;
            }

        }

        public void arrangeQueue()
        {
            while(!stackNewestOnTop.empty())
            {
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }


    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

/**
 * Input
 10
 1 42
 2
 1 14
 3
 1 28
 3
 1 60
 1 78
 2
 2
 **/