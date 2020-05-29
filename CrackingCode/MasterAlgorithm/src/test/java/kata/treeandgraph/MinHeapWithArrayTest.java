package kata.treeandgraph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MinHeapWithArrayTest {

    @Test
    public void insertElement() {
        MinHeapWithArray minHeapWithArray = new MinHeapWithArray(5);

        minHeapWithArray.insertElement(5);
        minHeapWithArray.insertElement(6);
        minHeapWithArray.insertElement(8);
        minHeapWithArray.insertElement(9);
        minHeapWithArray.insertElement(10);
        minHeapWithArray.insertElement(1);
        minHeapWithArray.insertElement(4);
        minHeapWithArray.insertElement(2);

        Assert.assertArrayEquals(minHeapWithArray.nodes,new int[]{0, 1, 2, 4, 6, 10, 8, 5, 9, 0});
        System.out.println(Arrays.toString(minHeapWithArray.nodes));
    }

    @Test
    public void peekMinElement() {
        MinHeapWithArray minHeapWithArray = new MinHeapWithArray(5);

        minHeapWithArray.insertElement(5);
        minHeapWithArray.insertElement(6);
        minHeapWithArray.insertElement(8);
        minHeapWithArray.insertElement(9);
        minHeapWithArray.insertElement(10);
        minHeapWithArray.insertElement(1);
        minHeapWithArray.insertElement(4);
        minHeapWithArray.insertElement(2);

        Assert.assertEquals(minHeapWithArray.peekMinElement(),1);
        System.out.println(Arrays.toString(minHeapWithArray.nodes));
    }

    @Test
    public void removeMinElement() {
        MinHeapWithArray minHeapWithArray = new MinHeapWithArray(5);

        minHeapWithArray.insertElement(5);
        minHeapWithArray.insertElement(6);
        minHeapWithArray.insertElement(8);
        minHeapWithArray.insertElement(9);
        minHeapWithArray.insertElement(10);
        minHeapWithArray.insertElement(1);
        minHeapWithArray.insertElement(4);
        minHeapWithArray.insertElement(2);
        System.out.println(Arrays.toString(minHeapWithArray.nodes));
        minHeapWithArray.removeMinElement();
        Assert.assertArrayEquals(minHeapWithArray.nodes,new int[]{0, 2, 9,4, 6, 10, 8, 5, 0, 0});
        System.out.println(Arrays.toString(minHeapWithArray.nodes));
    }
}