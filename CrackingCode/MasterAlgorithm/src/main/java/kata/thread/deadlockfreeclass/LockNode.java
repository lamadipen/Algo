package kata.thread.deadlockfreeclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockNode {
    int lockId;
    int maxLocks;
    List<LockNode> children;
    Lock lock;

    enum VISITING_STATE {FRESH, VISITING, VISITED}

    public LockNode(int lockId, int maxLocks) {
        this.lockId = lockId;
        this.maxLocks = maxLocks;
        children = new ArrayList<>();
    }

    public void joinTo(LockNode node) {
        children.add(node);
    }

    public void remove(LockNode node) {
        children.remove(node);
    }

    public boolean hasCycle(Map<Integer, Boolean> touchedNodes) {
        VISITING_STATE[] visited = new VISITING_STATE[maxLocks];
        for (int i = 0; i < maxLocks; i++) {
            visited[i] = VISITING_STATE.FRESH;
        }
        return hasCycle(visited, touchedNodes);
    }

    private boolean hasCycle(VISITING_STATE[] visited, Map<Integer, Boolean> touchedNodes) {
        if (touchedNodes.containsKey(lockId)) {
            touchedNodes.put(lockId, true);
        }

        if (visited[lockId] == VISITING_STATE.VISITING) {
            return true;
        } else if (visited[lockId] == VISITING_STATE.FRESH) {
            visited[lockId] = VISITING_STATE.VISITING;
            for (LockNode child : children) {
                if (child.hasCycle(visited, touchedNodes)) {
                    return true;
                }
            }
            visited[lockId] = VISITING_STATE.VISITED;
        }
        return false;
    }

    public Lock getLock() {
        if (lock == null) lock = new ReentrantLock();
        return lock;
    }
}
