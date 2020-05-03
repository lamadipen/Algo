package kata.linkedlist;

import java.util.Objects;

public class Node<T> {
    private T data;
    private Node next;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data == node.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
