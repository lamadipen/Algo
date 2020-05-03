package kata.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class SumListTest {
    @Test
    public void sumTwoListStoredInReverseOrderRecursiveTest() {
        CustomLinkedList list1 = new CustomLinkedList();
        list1.addToEnd(7);
        list1.addToEnd(1);
        list1.addToEnd(6);

        CustomLinkedList list2 = new CustomLinkedList();
        list2.addToEnd(5);
        list2.addToEnd(9);
        list2.addToEnd(2);

        Node actualHead= sumTwoListStoredInReverseOrderRecursive(list1.getHead(), list2.getHead(),0);

        CustomLinkedList expected = new CustomLinkedList();
        expected.addToEnd(2);
        expected.addToEnd(1);
        expected.addToEnd(9);
        Node expectedHead = expected.getHead();
        while (actualHead != null) {
            Assert.assertEquals(expectedHead.getData(), actualHead.getData());
            actualHead.getData();
            actualHead = actualHead.getNext();
            expectedHead = expectedHead.getNext();
        }
    }

    public Node sumTwoListStoredInReverseOrderRecursive(Node node1, Node node2, int carry) {
        if (node1 == null && node2 == null) {
            return null;
        }

        int  value = carry;

        if (node1 != null) {
            value += node1.getData();
        }
        if (node2 != null) {
            value += node2.getData();
        }

        Node result = new Node(value % 10);

        if (node1 != null || node2 != null) {
            Node many = sumTwoListStoredInReverseOrderRecursive(node1 != null ? node1.getNext() : null, node2 != null ? node2.getNext() : null, value / 10);
            result.setNext(many);
        }

        return result;
    }

    private CustomLinkedList sumTwoListStoredInReverseOrder(CustomLinkedList list1, CustomLinkedList list2) {
        Node node1 = list1.getHead();
        Node node2 = list2.getHead();
        CustomLinkedList newValue = new CustomLinkedList();
        int carryOver = 0;

        while (node1 != null && node2 != null) {
            int sum = node1.getData() + node2.getData();

            if (carryOver > 0) {
                sum += carryOver;
                carryOver = 0;
            }

            int quotient = sum % 10;

            carryOver = sum/10;
            newValue.addToEnd(quotient);

            node1 = node1.getNext();
            node2 = node2.getNext();
        }

        while (node1 != null){
            newValue.addToEnd(node1.getData());
            node1 = node1.getNext();
        }

        while (node2 != null){
            newValue.addToEnd(node2.getData());
            node2 = node2.getNext();
        }

        return newValue;
    }

    @Test
    public void sumTwoListStoredInReverseOrderTest() {
        CustomLinkedList list1 = new CustomLinkedList();
        list1.addToEnd(7);
        list1.addToEnd(1);
        list1.addToEnd(6);

        CustomLinkedList list2 = new CustomLinkedList();
        list2.addToEnd(5);
        list2.addToEnd(9);
        list2.addToEnd(2);

        CustomLinkedList customLinkedList = sumTwoListStoredInReverseOrder(list1, list2);
        Node actualHead = customLinkedList.getHead();

        CustomLinkedList expected = new CustomLinkedList();
        expected.addToEnd(2);
        expected.addToEnd(1);
        expected.addToEnd(9);
        Node expectedHead = expected.getHead();
        while (actualHead != null) {
            Assert.assertEquals(expectedHead.getData(), actualHead.getData());
            actualHead.getData();
            actualHead = actualHead.getNext();
            expectedHead = expectedHead.getNext();
        }
    }


    @Test
    public void sumTwoListStoredInForwardOrderTest() {
        CustomLinkedList list1 = new CustomLinkedList();
        list1.addToEnd(6);
        list1.addToEnd(1);
        list1.addToEnd(1);

        CustomLinkedList list2 = new CustomLinkedList();
        list2.addToEnd(2);
        list2.addToEnd(9);
        list2.addToEnd(5);

        Node actualHead = sumTwoListStoredInForwardOrder(list1.getHead(), list2.getHead());

        CustomLinkedList expected = new CustomLinkedList();
        expected.addToEnd(9);
        expected.addToEnd(1);
        expected.addToEnd(1);
        Node expectedHead = expected.getHead();

        Assert.assertNotNull(actualHead);

        while (actualHead != null) {
            Assert.assertEquals(expectedHead.getData(), actualHead.getData());
            actualHead.getData();
            actualHead = actualHead.getNext();
            expectedHead = expectedHead.getNext();
        }
    }

    public Node sumTwoListStoredInForwardOrder(Node list1Head, Node list2Head){
        if (list1Head == null) {
            return null;
        }
        if (list2Head == null) {

        }
        return  null;
    }
}
