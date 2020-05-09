package kata.stackqueue;

import java.util.Stack;

public class StackMinOOP extends Stack<StackMinNode> {
    public void push(int data) {
        int newMin = Math.min(data, getPrevMin());
        super.push(new StackMinNode(data, newMin));
    }

    private int getPrevMin() {
        if (super.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            StackMinNode peek = super.peek();
            return peek.minValue;
        }
    }

    public int getMin() {
        return super.peek().minValue;
    }
}
