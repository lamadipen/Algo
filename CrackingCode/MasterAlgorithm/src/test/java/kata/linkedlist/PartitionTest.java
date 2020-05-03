package kata.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Partition linkedlist around given value x,
 * node less than x should come before all node that is
 * greater or equal to x
 */
public class PartitionTest {

    @Test
    public void partitionUsingTwoPointerTest() {
        CustomLinkedList input = new CustomLinkedList();
        input.addToEnd(3);
        input.addToEnd(5);
        input.addToEnd(8);
        input.addToEnd(5);
        input.addToEnd(10);
        input.addToEnd(2);
        input.addToEnd(1);

        int partitionPoint = 5;

        CustomLinkedList actual = partitionUsingTwoPointerPoint(input, partitionPoint);

        CustomLinkedList expected = new CustomLinkedList();
        expected.addToEnd(3);
        expected.addToEnd(2);
        expected.addToEnd(1);
        expected.addToEnd(5);
        expected.addToEnd(10);
        expected.addToEnd(5);
        expected.addToEnd(8);

        Node actualHead = actual.getHead();
        Node expectedHead = expected.getHead();
        while (actualHead != null) {
            System.err.println(actualHead.getData());
            Assert.assertEquals(expectedHead.getData(), actualHead.getData());
            actualHead = actualHead.getNext();
            expectedHead = expectedHead.getNext();
        }
    }

    private CustomLinkedList partitionUsingTwoPointerPoint(CustomLinkedList input, int partitionPoint) {

        Node slowPointer = input.getHead();
        Node fastPointer = input.getHead().getNext();
        Node previous = null;

        while (fastPointer != null) {
            if (fastPointer.getData() >= partitionPoint) {
                fastPointer = fastPointer.getNext();
            } else {
                if (previous == null) {
                    previous = slowPointer;
                    slowPointer = slowPointer.getNext();
                    fastPointer = slowPointer.getNext();
                } else {
                    int tempValue = fastPointer.getData();
                    fastPointer.setData(slowPointer.getData());
                    slowPointer.setData(tempValue);
                    slowPointer = slowPointer.getNext();
                }
            }
        }
        return input;
    }

    @Test
    public void partitionUsingTwoHalfTest() {
        CustomLinkedList input = new CustomLinkedList();
        input.addToEnd(3);
        input.addToEnd(5);
        input.addToEnd(8);
        input.addToEnd(5);
        input.addToEnd(10);
        input.addToEnd(2);
        input.addToEnd(1);

        int partitionPoint = 5;

        Node actualHead = partitionUsingTwoHalf(input, partitionPoint);

        CustomLinkedList expected = new CustomLinkedList();
        expected.addToEnd(3);
        expected.addToEnd(2);
        expected.addToEnd(1);
        expected.addToEnd(5);
        expected.addToEnd(10);
        expected.addToEnd(5);

        Node expectedHead = expected.getHead();

        while (actualHead != null) {
            System.err.println(actualHead.getData());
            Assert.assertEquals(expectedHead.getData(), actualHead.getData());
            actualHead = actualHead.getNext();
            expectedHead = expectedHead.getNext();
        }
    }

    private Node partitionUsingTwoHalf(CustomLinkedList input, int partitionPoint) {
        Node lowHalf = null;
        Node lowHalfHead = null;
        Node highHalf = null;
        Node highHalfHead = null;
        Node tempHead = input.getHead();

        while (tempHead != null) {
            Node replacerNode = tempHead;
            replacerNode.setNext(null);
            if (tempHead.getData() < partitionPoint) {
                if (lowHalf == null) {
                    lowHalf = replacerNode;
                    lowHalfHead = lowHalf;
                } else {
                    lowHalf.setNext(replacerNode);
                    lowHalf = lowHalf.getNext();
                }
            } else {
                if (highHalf == null) {
                    highHalf = replacerNode;
                    highHalfHead = highHalf;
                } else {

                    highHalf.setNext(replacerNode);
                    highHalf = highHalf.getNext();
                }

            }
            tempHead = tempHead.getNext();
        }

        lowHalf.setNext(highHalfHead);

        return lowHalfHead;
    }


    @Test
    public void partitionUsingTwoHalfWithLimitedVariablesTest() {
        CustomLinkedList input = new CustomLinkedList();
        input.addToEnd(3);
        input.addToEnd(5);
        input.addToEnd(8);
        input.addToEnd(5);
        input.addToEnd(10);
        input.addToEnd(2);
        input.addToEnd(1);

        int partitionPoint = 5;

        Node actualHead = partitionUsingTwoHalfWithLimitedVariablesTest(input, partitionPoint);

        CustomLinkedList expected = new CustomLinkedList();
        expected.addToEnd(3);
        expected.addToEnd(2);
        expected.addToEnd(1);
        expected.addToEnd(5);
        expected.addToEnd(10);
        expected.addToEnd(5);

        Node expectedHead = expected.getHead();

        while (actualHead != null) {
            System.err.println(actualHead.getData());
            Assert.assertEquals(expectedHead.getData(), actualHead.getData());
            actualHead = actualHead.getNext();
            expectedHead = expectedHead.getNext();
        }
    }

    private Node partitionUsingTwoHalfWithLimitedVariablesTest(CustomLinkedList input, int partitionPoint) {
        Node lowHalf = input.getHead();
        Node highHalf = input.getHead();
        Node tempHead = input.getHead();

        while (tempHead != null) {
            Node next = tempHead.getNext();
            if (tempHead.getData() < partitionPoint) {
                tempHead.setNext(lowHalf);
                lowHalf = tempHead;
            } else {
                highHalf.setNext(tempHead);
                highHalf = tempHead;
            }
            tempHead = next;
        }
        highHalf.setNext(null);

        return lowHalf;

    }

}
