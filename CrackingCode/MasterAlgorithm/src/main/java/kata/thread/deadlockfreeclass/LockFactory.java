package kata.thread.deadlockfreeclass;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public class LockFactory {
    static LockFactory instance;
    int maxLocks = 5;
    LockNode[] locks;
    Map<Integer, LinkedList<LockNode>> lockOrder;

    private LockFactory(int count) {
        this.maxLocks = count;
        locks = new LockNode[count];
        lockOrder = new HashMap<>();
        for (int i = 0; i < count; i++) {
            locks[i] = new LockNode(i, count);
        }
    }

    public static LockFactory getInstance() {
        return instance;
    }

    public static synchronized LockFactory initialize(int count) {
        if (instance == null) instance = new LockFactory(count);
        return instance;
    }

    public boolean declare(int ownerId, int[] resourcesInOrder) {
        Map<Integer, Boolean> touchedNodes = new HashMap<>();
        int index = 1;
        touchedNodes.put(resourcesInOrder[0], false);
        for (index = 1; index < resourcesInOrder.length; index++) {
            LockNode previous = locks[index - 1];
            LockNode current = locks[index];
            previous.joinTo(current);
            touchedNodes.put(resourcesInOrder[index], false);
        }

        if (hasCycle(touchedNodes, resourcesInOrder)) {
            for (int j = 1; j < resourcesInOrder.length; j++) {
                LockNode previous = locks[index - 1];
                LockNode current = locks[index];
                previous.remove(current);
            }
            return false;
        }

        LinkedList<LockNode> list = new LinkedList<>();
        for (int i = 0; i < resourcesInOrder.length; i++) {
            LockNode resource = locks[resourcesInOrder[i]];
            list.add(resource);
        }
        lockOrder.put(ownerId, list);
        return true;
    }

    private boolean hasCycle(Map<Integer, Boolean> touchedNodes, int[] resourcesInOrder) {
        for (int resource : resourcesInOrder) {
            if (touchedNodes.get(resource) == false) {
                LockNode node = locks[resource];
                if (node.hasCycle(touchedNodes)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Lock getLock(int ownerId, int resourceId) {
        LinkedList<LockNode> list = lockOrder.get(ownerId);
        if (list == null) {
            return null;
        }

        LockNode head = list.getFirst();
        if (head.lockId == resourceId) {
            list.removeFirst();
            return head.getLock();
        }
        return null;
    }


}
