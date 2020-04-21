package kata.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicateTest {

    @Test
    public void removeDuplicate() {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addToEnd(3);
        customLinkedList.addToEnd(1);
        customLinkedList.addToEnd(2);
        customLinkedList.addToEnd(3);
        customLinkedList.addToEnd(4);
        customLinkedList.addToEnd(5);
        customLinkedList.addToEnd(1);


        Node actual = removeDuplicate.remove(customLinkedList);

        CustomLinkedList expected = new CustomLinkedList();
        expected.addToEnd(3);
        expected.addToEnd(1);
        expected.addToEnd(2);
        expected.addToEnd(4);
        expected.addToEnd(5);

        Node expectedHead = expected.getHead();

        while (actual != null) {
            Assert.assertEquals(expectedHead, actual);
            expectedHead = expectedHead.getNext();
            actual = actual.getNext();
        }
    }

}