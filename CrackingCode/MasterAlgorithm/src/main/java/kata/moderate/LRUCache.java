package kata.moderate;

import java.util.HashMap;
import java.util.Map;

/**
 * Moderate
 * LRU Cache
 * CC: pg 185 Q: 16.25
 */
public class LRUCache {
    int maxSize;
    Map<String, LRUNode> map = new HashMap<>();
    LRUNode head = null;
    LRUNode tail = null;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
    }

    public void insertKeyValue(String key, String value) {
        removeKey(key);
        if (map.size() >= maxSize && tail != null) {
            removeKey(tail.key);
        }
        LRUNode lruNode = new LRUNode(key, value);
        insertAtBeginingOfLinkedList(lruNode);
        map.put(key, lruNode);
    }

    private void insertAtBeginingOfLinkedList(LRUNode lruNode) {
        if (head == null) {
            head = lruNode;
            tail = lruNode;
        } else {
            head.previous = lruNode;
            lruNode.next = head;
            head = lruNode;
        }
    }

    public void removeKey(String key) {
        LRUNode lruNode = map.get(key);
        removeFromLinkList(lruNode);
        map.remove(key);
    }

    public String getValueByKey(String key) {
        LRUNode lruNode = map.get(key);
        if (lruNode == null) {
            return null;
        }
        if (lruNode != head) {
            removeFromLinkList(lruNode);
            insertAtBeginingOfLinkedList(lruNode);
        }
        return lruNode.value;
    }

    private void removeFromLinkList(LRUNode lruNode) {
        if (lruNode == null) return;
        if (lruNode.previous != null) lruNode.previous.next = lruNode.next;
        if (lruNode.next != null) lruNode.next.previous = lruNode.previous;
        if (lruNode == head) head = lruNode.next;
        if (lruNode == tail) tail = lruNode.previous;
    }
}

class LRUNode {
    String key;
    String value;
    LRUNode previous, next;

    public LRUNode(String key, String value) {
        this.key = key;
        this.value = value;
    }
}