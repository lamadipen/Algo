package kata.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class FindKthItemToLastElementTest {

    @Test
    public void findKthItemToLastElementIterative() {
        FindKthItemToLastElement findKthItemToLastElement = new FindKthItemToLastElement();

        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addToEnd(3);
        customLinkedList.addToEnd(1);
        customLinkedList.addToEnd(2);
        customLinkedList.addToEnd(8);
        customLinkedList.addToEnd(4);
        customLinkedList.addToEnd(5);
        customLinkedList.addToEnd(10);

        Node actual = findKthItemToLastElement.findKthToLastIterative(customLinkedList, 3);

        Assert.assertEquals(4, actual.getData());
    }

    @Test
    public void findKthItemToLastElementRecursive() {
        FindKthItemToLastElement findKthItemToLastElement = new FindKthItemToLastElement();

        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addToEnd(3);
        customLinkedList.addToEnd(1);
        customLinkedList.addToEnd(2);
        customLinkedList.addToEnd(8);
        customLinkedList.addToEnd(4);
        customLinkedList.addToEnd(5);
        customLinkedList.addToEnd(10);

        findKthItemToLastElement.findKthToLastRecursive(customLinkedList, 3);
        //Check Console for the output should be 4
    }

    @Test
    public void findKthItemToLastElementRecursiveWithObject() {
        FindKthItemToLastElement findKthItemToLastElement = new FindKthItemToLastElement();

        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addToEnd(3);
        customLinkedList.addToEnd(1);
        customLinkedList.addToEnd(2);
        customLinkedList.addToEnd(8);
        customLinkedList.addToEnd(4);
        customLinkedList.addToEnd(5);
        customLinkedList.addToEnd(10);

        Node actual = findKthItemToLastElement.findKthToLastRecursiveObject(customLinkedList, 3);

        Assert.assertEquals(4, actual.getData());
    }


    @Test
    public void findKthItemToLastElementRecursiveWithObjectFailed() {
        FindKthItemToLastElement findKthItemToLastElement = new FindKthItemToLastElement();

        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addToEnd(3);
        customLinkedList.addToEnd(1);
        customLinkedList.addToEnd(2);
        customLinkedList.addToEnd(8);
        customLinkedList.addToEnd(4);
        customLinkedList.addToEnd(5);
        customLinkedList.addToEnd(10);

        Node actual = findKthItemToLastElement.findKthToLastRecursiveObjectFailed(customLinkedList, 3);

        Assert.assertEquals(4, actual.getData());
    }



}