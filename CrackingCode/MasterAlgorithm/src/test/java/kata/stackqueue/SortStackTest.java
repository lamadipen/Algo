package kata.stackqueue;

import org.junit.Test;

public class SortStackTest {

    @Test
    public void sortStackTest() {
        SortStack sortStack = new SortStack();
        sortStack.push(8);
        sortStack.push(4);
        sortStack.push(9);
        sortStack.push(1);

        sortStack.sort();

        while (!sortStack.isEmpty()) {
            System.err.println(sortStack.pop());
        }

    }
}
