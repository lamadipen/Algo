package kata.stackqueue;

import java.util.Stack;

public class SortStack {

    private Stack<Integer> unsorted = new Stack<>();
    private Stack<Integer> sorted = new Stack<>();
    ;

    public void push(int data) {
        unsorted.push(data);
    }

    public int pop() {
        sort();
        return unsorted.pop();
    }

    public int peek() {
        sort();
        return unsorted.peek();
    }

    public boolean isEmpty() {
        return unsorted.isEmpty();
    }

    public void sort() {
        while (!unsorted.isEmpty()) {
            Integer temp = unsorted.pop();
            while (!sorted.isEmpty() && sorted.peek() > temp) {
                unsorted.push(sorted.pop());
            }
            sorted.push(temp);
        }

        while (!sorted.isEmpty()) {
            unsorted.push(sorted.pop());
        }
    }

}

