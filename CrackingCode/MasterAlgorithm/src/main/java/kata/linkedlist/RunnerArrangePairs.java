package kata.linkedlist;

public class RunnerArrangePairs {


    public CustomLinkedList arrangeIntoPairs(CustomLinkedList customLinkedList) {
        Node slowNode = customLinkedList.getHead();
        Node fastNode = customLinkedList.getHead().getNext();

        while (slowNode != null && fastNode != null) {
            slowNode = slowNode.getNext();

            if (fastNode.getNext() != null) {
                fastNode = fastNode.getNext().getNext();
            } else {
                fastNode = fastNode.getNext();
            }
        }

        fastNode = slowNode;
        slowNode = customLinkedList.getHead();
        boolean insertFromFastNode = false;
        CustomLinkedList actual = new CustomLinkedList();

        while (fastNode != null) {
            if (insertFromFastNode) {
                actual.addToEnd(fastNode.getData());
                fastNode = fastNode.getNext();
                insertFromFastNode = false;
            } else {
                actual.addToEnd(slowNode.getData());
                slowNode = slowNode.getNext();
                insertFromFastNode = true;
            }
        }

        return actual;
    }
}
