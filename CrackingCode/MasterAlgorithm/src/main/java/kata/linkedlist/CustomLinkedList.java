package kata.linkedlist;

/** Write the CustomLinked List with crud operations*/
public class CustomLinkedList {
    private int size = 0;
    private Node head;

    public void addToEnd(int data) {
        if (head == null) {
            head = new Node(data);
            size++;
            return;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(new Node(data));
        size++;
    }

    public int size() {
        return size;
    }

    public Node get(int data) {
        if (head == null) {
            return null;
        }
        if (head.getData() == data) {
            return head;
        }
        Node tempNode = head;

        while (tempNode.getNext() != null) {
            Node nextNode = tempNode.getNext();
            if (nextNode.getData() == data) {
                return nextNode;
            }
            tempNode = tempNode.getNext();
        }
        return null;
    }

    public void removeFromEnd(int data) {
        if (head.getData() == data) {
            head = head.getNext();
            size--;
            return;
        }

        Node tempNode = head;
        while (tempNode.getNext() != null) {
            if (tempNode.getNext().getData() == data) {
                tempNode.setNext(tempNode.getNext().getNext());
                break;
            }
            tempNode = tempNode.getNext();
        }

        size--;
    }

    public Node getHead() {
        return head;
    }
}
