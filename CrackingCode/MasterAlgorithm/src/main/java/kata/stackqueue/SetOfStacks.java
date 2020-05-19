package kata.stackqueue;

import java.util.ArrayList;
import java.util.List;


/**Follow up of the  stack of plates*/
public class SetOfStacks {
    List<Stack> stacks = new ArrayList<>();
    int capacity;
    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if(stacks.isEmpty()) return null;
        return stacks.get(stacks.size() - 1);
    }

    public boolean isEmpty() {
        Stack lastStack = getLastStack();
        return lastStack == null || lastStack.isEmpty();
    }

    public void push(int data) {
        Stack lastStack = getLastStack();
        if (lastStack == null || lastStack.size >= capacity) {
            Stack stack = new Stack(capacity);
            stack.push(data);
            stacks.add(stack);
        } else {
            lastStack.push(data);
        }
    }

    public int popAtIndex(int index) {
        return leftShift(index, true);
    }

    private int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);

        int removedItem;
        if(removeTop) removedItem = stack.pop();
        else removedItem = stack.removeBottom();

        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removedItem;
    }

}

class Stack{
    private int capacity;
    public Node top, bottom;
    public int size =0;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public void join(Node above, Node below) {
        if(below != null) below.above = above;
        if(above != null) above.below = below;
    }

    public boolean push(int data) {
        if(size >= capacity) return false;
        size++;
        Node node = new Node(data);
        if(size == 1) bottom = node;
        join(node, top);
        top = node;
        return true;
    }

    public int pop() {
        Node t = top;
        top = top.below;
        size--;
        return t.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int removeBottom() {
        Node b = bottom;
        bottom = bottom.above;
        if(bottom != null) bottom.below = null;
        size--;
        return b.value;
    }

}

class Node{
    int value;
    Node above;
    Node below;
    public Node(int data) {
        this.value = data;
    }
}