package kata.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackOfPlates {
    List<Stack<Integer>> stacks = new ArrayList<>();
    int stackSize;
    int currentPointer = -1;

    public StackOfPlates(int stackSize) {
        this.stackSize = stackSize;
    }

    public void push(int data) {
        if (stacks.isEmpty()) {
            Stack<Integer> innerStack = new Stack<>();
            innerStack.push(data);
            stacks.add(innerStack);
            currentPointer++;
        } else {
            Stack<Integer> innerStack = stacks.get(currentPointer);

            if (innerStack.size() == stackSize) {
                Stack<Integer> stack = new Stack<>();
                stack.push(data);
                stacks.add(stack);
                currentPointer++;
            }else {
                innerStack.push(data);
            }
        }
    }

    public int pop() {
        if (stacks.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        Stack<Integer> innerStack = stacks.get(currentPointer);
        Integer pop = innerStack.pop();
        if (innerStack.isEmpty()) {
            stacks.remove(currentPointer);
            currentPointer--;
        }
        return pop;
    }
}
