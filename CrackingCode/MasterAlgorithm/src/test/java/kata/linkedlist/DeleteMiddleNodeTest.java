package kata.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class DeleteMiddleNodeTest {

    @Test
    public void deleteMiddleNodeTest() {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addToEnd(1);
        customLinkedList.addToEnd(2);
        customLinkedList.addToEnd(4);
        customLinkedList.addToEnd(3);
        customLinkedList.addToEnd(6);
        customLinkedList.addToEnd(8);
        customLinkedList.addToEnd(9);

        Node node = customLinkedList.getHead().getNext().getNext();

        DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();
        deleteMiddleNode.deleteMiddleNode(node);

        Node currentHead = customLinkedList.getHead();
        while (currentHead != null) {
            System.out.println("values " + currentHead.getData());
            Assert.assertNotEquals(currentHead.getData(), 4 );
            currentHead = currentHead.getNext();
        }

    }
}