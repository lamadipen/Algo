package kata.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class Palindrome {

    @Test
    public void isLinkListPalindrome() {

//Madam
//Mom
//Noon
//Racecar
//Radar
//Redder
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addToEnd("m");
        customLinkedList.addToEnd("a");
        customLinkedList.addToEnd("d");
        customLinkedList.addToEnd("a");
        customLinkedList.addToEnd("m");

        boolean isPalindrome = isPalindrome(customLinkedList.getHead());
        Assert.assertTrue(isPalindrome);

        CustomLinkedList customLinkedList1 = new CustomLinkedList();
        customLinkedList.addToEnd("m");
        customLinkedList.addToEnd("a");
        customLinkedList.addToEnd("d");
        customLinkedList.addToEnd("a");
        customLinkedList.addToEnd("m");
        customLinkedList.addToEnd("c");

        boolean isPalindrome1 = isPalindrome(customLinkedList1.getHead());
        Assert.assertTrue(isPalindrome1);
    }

    private boolean isPalindrome(Node head) {
        HashMap<String, Integer> map = new HashMap<>();

        while (head != null) {
            String data = (String) head.getData();

            if (map.containsKey(data)) {
                map.put(data, map.get(data) - 1);
            }else{
                map.putIfAbsent(data, 1);
            }
            head = head.getNext();
        }

        if (map.size() % 2 == 0) {
            long count = map
                    .entrySet()
                    .stream()
                    .filter((entry) -> entry.getValue() > 0)
                    .count();
            return count ==0 ? true: false;
        }else{
            long count = map
                    .entrySet()
                    .stream()
                    .filter((entry) -> entry.getValue() > 0)
                    .count();
            return count == 1? true: false;
        }
    }
}
