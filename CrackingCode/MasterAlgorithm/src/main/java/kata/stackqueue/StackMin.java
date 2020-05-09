package kata.stackqueue;

public class StackMin {
    int[] stack;
    int[] minTracker;
    int min = Integer.MAX_VALUE;
    int topIndex = 0;

    public StackMin(int size) {
        stack = new int[size];
        minTracker = new int[size];
    }

    public void push(int data) {
        if (topIndex >= stack.length) {
            throw new RuntimeException("Stack out of space");
        }
        if (data < min) {
            min = data;
            minTracker[topIndex] = data;
        }
        stack[topIndex] = data;
        topIndex++;
    }

    public int getMin() {
        return min;
    }

    public int pop() {
        if (topIndex < 0) {
            throw new RuntimeException("Stack is empty");
        }
        if (topIndex == 0) {
            min = stack[topIndex];
        }else{
            min = minTracker[topIndex-2];
        }
        int result = stack[topIndex];
        topIndex--;
        return result;
    }
}
