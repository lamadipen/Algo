package hackerrank.interviewprepkit.linkedlist;

import org.junit.Assert;
import org.junit.Test;


public class InsertingNodeIntoSortedDoublyLinkedListSolutionTest {

    @Test
    public void sortedInsertNullHead() {
        DoublyLinkedListNode actaul = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(null, 1);
        Assert.assertNotNull(actaul);
        Assert.assertEquals(1, actaul.data);
    }

    @Test
    public void sortedInsertWithHeadAndSmallerInput() {
        DoublyLinkedListNode head = new DoublyLinkedListNode(3);
        DoublyLinkedListNode actaul = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(head, 1);
        Assert.assertNotNull(actaul);
        Assert.assertEquals(1, actaul.data);
        Assert.assertEquals(3, actaul.next.data);
    }

    @Test
    public void sortedInsertWithHeadAndBiggerInput() {
        DoublyLinkedListNode head = new DoublyLinkedListNode(3);
        DoublyLinkedListNode actaul = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(head, 5);
        Assert.assertNotNull(actaul);
        Assert.assertEquals(3, actaul.data);
        Assert.assertEquals(5, actaul.next.data);
    }

    @Test
    public void sortedInsertWithLinkedList() {

        DoublyLinkedListNode node1 = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(null, 5);
        DoublyLinkedListNode node2 = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(node1, 1);
        DoublyLinkedListNode node3 = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(node2, 2);

        DoublyLinkedListNode actual = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(node3, 4);

        Assert.assertNotNull(actual);
        Assert.assertEquals(1, actual.data);
        Assert.assertEquals(2, actual.next.data);
        Assert.assertEquals(4, actual.next.next.data);
        Assert.assertEquals(5, actual.next.next.next.data);
        Assert.assertEquals(null, actual.next.next.next.next);
    }

    @Test
    public void sortedInsertWithLinkedListShouldAddAtEnd() {

        DoublyLinkedListNode node1 = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(null, 5);
        DoublyLinkedListNode node2 = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(node1, 1);
        DoublyLinkedListNode node3 = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(node2, 2);

        DoublyLinkedListNode actual = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(node3, 6);

        Assert.assertNotNull(actual);
        Assert.assertEquals(1, actual.data);
        Assert.assertEquals(2, actual.next.data);
        Assert.assertEquals(5, actual.next.next.data);
        Assert.assertEquals(6, actual.next.next.next.data);
    }

    @Test
    public void sortedInsertWithLinkedListRecursiceShouldAddAtEnd() {

        DoublyLinkedListNode node1 = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(null, 5);
        DoublyLinkedListNode node2 = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(node1, 1);
        DoublyLinkedListNode node3 = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(node2, 2);

        DoublyLinkedListNode actual = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsertRecursive(node3, 6);

        Assert.assertNotNull(actual);
        Assert.assertEquals(1, actual.data);
        Assert.assertEquals(2, actual.next.data);
        Assert.assertEquals(5, actual.next.next.data);
        Assert.assertEquals(6, actual.next.next.next.data);
    }

    @Test
    public void sortedInsertWithLinkedListOptimized() {

        DoublyLinkedListNode node1 = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(null, 5);
        DoublyLinkedListNode node2 = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(node1, 1);
        DoublyLinkedListNode node3 = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsert(node2, 2);

        DoublyLinkedListNode actual = InsertingNodeIntoSortedDoublyLinkedListSolution.sortedInsertRecursive(node3, 4);

        Assert.assertNotNull(actual);
        Assert.assertEquals(1, actual.data);
        Assert.assertEquals(2, actual.next.data);
        Assert.assertEquals(4, actual.next.next.data);
        Assert.assertEquals(5, actual.next.next.next.data);
        Assert.assertEquals(null, actual.next.next.next.next);
    }
}