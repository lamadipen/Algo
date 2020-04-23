package kata.linkedlist;
/**
 * Delete a node in the middle from the singly linkedlist, given access only  that node
 * Example
 * input Node [3] from singly linked list  1, 2, 4, 3, 6, 8, 9
 * return no thing but the linked lists like 1, 2, 4, 6, 8, 9
 * */
public class DeleteMiddleNode {
    public void deleteMiddleNode(Node node) {
        if (node.getNext() != null) {
            node.setData(node.getNext().getData());
            node.setNext(node.getNext().getNext());
        }
    }
}
