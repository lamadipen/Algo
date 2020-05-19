package kata.stackqueue;

import java.util.Stack;

public class QueueViaStack {
   Stack<Integer> primary = new Stack<>(); // can be named as newest stack
   Stack<Integer> secondary = new Stack<>(); //can be named as oldest stack

    public void queue(int data) {
        primary.push(data);
    }

    public int dequeue() {
        shiftStacks();
        return secondary.pop();
    }

    private void shiftStacks() {
        if (secondary.isEmpty()) {
            while (!primary.isEmpty()){
                secondary.push(primary.pop());
            }
        }
    }

    public int peek() {
        shiftStacks();
        return secondary.peek();
    }

    public int size() {
        return primary.size() + secondary.size();
    }
}
