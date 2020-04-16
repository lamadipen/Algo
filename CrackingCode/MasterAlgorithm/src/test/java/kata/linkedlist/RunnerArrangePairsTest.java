package kata.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class RunnerArrangePairsTest {

    @Test
    public void arrangePairTest() {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addToEnd(0);
        customLinkedList.addToEnd(0);
        customLinkedList.addToEnd(0);
        customLinkedList.addToEnd(0);
        customLinkedList.addToEnd(0);
        customLinkedList.addToEnd(1);
        customLinkedList.addToEnd(1);
        customLinkedList.addToEnd(1);
        customLinkedList.addToEnd(1);
        customLinkedList.addToEnd(1);

        RunnerArrangePairs runner = new RunnerArrangePairs();
        CustomLinkedList acutal = runner.arrangeIntoPairs(customLinkedList);

        CustomLinkedList expected = new CustomLinkedList();
        expected.addToEnd(0);
        expected.addToEnd(1);
        expected.addToEnd(0);
        expected.addToEnd(1);
        expected.addToEnd(0);
        expected.addToEnd(1);
        expected.addToEnd(0);
        expected.addToEnd(1);
        expected.addToEnd(0);
        expected.addToEnd(1);

        Node actualHead = acutal.getHead();
        Node expectedHead = expected.getHead();

        while (actualHead != null) {
            Assert.assertEquals(expectedHead, actualHead);
            actualHead = actualHead.getNext();
            expectedHead = expectedHead.getNext();
        }


    }

}