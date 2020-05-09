package kata.stackqueue;

import java.util.Stack;

public class StackMinTwoStack extends Stack<Integer> {
    Stack<Integer> minTracker;

    public StackMinTwoStack() {
        this.minTracker = new Stack<>();
    }
    public void push(int data) {
        int newMin = Math.min(data, getPrevMin());
        if (newMin >= data) {
            minTracker.push(data);
        }
        super.push(data);
    }

    public Integer pop(){
        Integer pop = super.pop();
        if (pop == minTracker.peek()) {
            minTracker.pop();
        }
        return pop;
    }

    private int getPrevMin() {
        if (super.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minTracker.peek();
        }
    }

    public int getMin() {
        return minTracker.peek();
    }
}
