package kata.treeandgraph;

import org.junit.Assert;
import org.junit.Test;

public class MinHeapTest {
    /**
     * 1
     * 5     8
     * 7   9  10  12
     */
    @Test
    public void testInsertElement() {
        MinHeap minHeap = new MinHeap();
        minHeap.insertElement(5);
        minHeap.insertElement(8);
        minHeap.insertElement(7);
        minHeap.insertElement(9);
        minHeap.insertElement(10);
        minHeap.insertElement(12);
    }

    @Test
    public void testRemoveMinElement() {
        MinHeap minHeap = new MinHeap();
        minHeap.insertElement(5);
        minHeap.insertElement(8);
        minHeap.insertElement(7);
        minHeap.insertElement(9);
        minHeap.insertElement(10);
        minHeap.insertElement(12);

        minHeap.removeMinElement();

    }

    @Test
    public void testPeekMinElement() {
        MinHeap minHeap = new MinHeap();
        minHeap.insertElement(5);
        minHeap.insertElement(8);
        minHeap.insertElement(7);
        minHeap.insertElement(9);
        minHeap.insertElement(10);
        minHeap.insertElement(12);

        Assert.assertEquals(5, minHeap.peekMinElement());
    }

}