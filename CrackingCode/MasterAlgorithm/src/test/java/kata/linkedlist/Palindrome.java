package kata.linkedlist;

import org.junit.Test;

public class Palindrome {

    @Test
    public void isLinkListPalindrome() {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addToEnd(3);
        customLinkedList.addToEnd(1);
        customLinkedList.addToEnd(2);
        customLinkedList.addToEnd(3);
        customLinkedList.addToEnd(4);
        customLinkedList.addToEnd(5);
        customLinkedList.addToEnd(1);
    }
}
