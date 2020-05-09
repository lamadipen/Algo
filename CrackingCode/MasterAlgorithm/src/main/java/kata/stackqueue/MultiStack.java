package kata.stackqueue;

public class MultiStack {
    int stackCapacity;
    int numberOfStack;
    int [] stack;
    int [] sizes;
    public MultiStack(int stackCapacity, int numberOfStack) {
        this.stackCapacity = stackCapacity;
        this.numberOfStack = numberOfStack;
        stack = new int[stackCapacity * numberOfStack];
        sizes = new int[numberOfStack];
    }

    public void push(int stackNum, int data) {
        if(isFull(stackNum)) throw new RuntimeException("Stack is full");
        int index = indexOfTop(stackNum);
        stack[index] = data;
        sizes[stackNum]++;
    }

    private int indexOfTop(int stackNum) {
        int currentStackSize = sizes[stackNum];
        int index = 0;
        if (isEmpty(stackNum)) {
            return  stackNum * stackCapacity;
        }else{
            index = (currentStackSize + (stackNum * stackCapacity));
        }
        return index;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] >= stackCapacity;
    }

    private boolean isEmpty(int stackNum) {
        return 0 == sizes[stackNum];
    }

    public int pop(int stackNum) {
        if(isEmpty(stackNum)) throw new RuntimeException("Stack is empty");
        int index = indexOfTop(stackNum) -1;
        return stack[index];
    }
}
