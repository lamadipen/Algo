package kata.stackqueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class StackOfPlatesFromBook {
    List<Stack<Integer>> stacks = new ArrayList<>();
    int stackSize;
    int currentPointer = -1;

    public StackOfPlatesFromBook(int stackSize) {
        this.stackSize = stackSize;
    }

    public void push(int data) {
        Stack<Integer> topStack = getTopStack();
        if (topStack == null || isFull(topStack)) {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(data);
            stacks.add(newStack);
            currentPointer++;
        }else{
            topStack.push(data);
        }
    }

    public int pop() {
        Stack<Integer> topStack = getTopStack();
        if (topStack == null) {
            throw new EmptyStackException();
        }
        Integer pop = topStack.pop();
        if (topStack.isEmpty()) {
            stacks.remove(currentPointer);
            currentPointer--;
        }
        return pop;
    }

    private boolean isFull(Stack<Integer> topStack) {
        return topStack.size() == stackSize;
    }

    private Stack<Integer> getTopStack() {
        if (stacks.isEmpty()) {
            return null;
        }
        return stacks.get(currentPointer);
    }

}
