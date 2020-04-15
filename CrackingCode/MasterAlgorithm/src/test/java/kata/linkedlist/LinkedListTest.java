package kata.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void addToEndTest() {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        Assert.assertEquals(0, customLinkedList.size());

        customLinkedList.addToEnd(1);
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        customLinkedList.get(1);
        Assert.assertEquals(1, customLinkedList.size());
        Assert.assertEquals(node1, customLinkedList.get(1));
        Assert.assertNull(customLinkedList.get(1).getNext());

        customLinkedList.addToEnd(2);
        Assert.assertEquals(node2, customLinkedList.get(2));
    }


    @Test
    public void canGetNode() {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addToEnd(1);
        Assert.assertEquals(1, customLinkedList.size());
        Node expected = new Node(1);

        Assert.assertEquals(expected, customLinkedList.get(1));
        Assert.assertEquals(expected, customLinkedList.get(1));
        Assert.assertEquals(expected, customLinkedList.get(1));
        Assert.assertEquals(expected, customLinkedList.get(1));
    }


    @Test
    public void canRemoveFromEnd() {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        Node node = new Node(1);
        customLinkedList.addToEnd(1);
        customLinkedList.removeFromEnd(1);

        Assert.assertEquals(0, customLinkedList.size());
        Assert.assertNull(customLinkedList.get(1));

        customLinkedList.addToEnd(1);
        customLinkedList.addToEnd(2);
        customLinkedList.addToEnd(3);
        customLinkedList.removeFromEnd(3);
        Assert.assertEquals(2, customLinkedList.size());
        Assert.assertNull(customLinkedList.get(3));
    }
}
