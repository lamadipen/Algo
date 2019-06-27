package com.ccinterview.thread.DeadlockFreeClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockNode {
    public enum VisitState { FRESH, VISITING, VISITED};

    private ArrayList<LockNode> children;
    private int lockId;
    private Lock lock;
    private int maxLocks;

    public LockNode(int id, int max) {
        this.lockId = id;
        this.maxLocks = max;
    }

    //Join this to node checking that it doesn't create a cycle
    public void joinTo(LockNode node){
        children.add(node);
    }

    public void remove(LockNode node) {
        children.remove(node);
    }

    //check for cycle by doing depth first search
    public boolean hasCycle(HashMap<Integer,Boolean> touchNodes) {
        VisitState[] visited = new VisitState[maxLocks];

        for (int i = 0; i < maxLocks; i++) {
            visited[i] = VisitState.FRESH;
        }

        return  hasCycle(visited, touchNodes);
    }

    private boolean hasCycle(VisitState[] visited, HashMap<Integer, Boolean> touchNodes) {
        if (touchNodes.containsKey(lockId)) {
            touchNodes.put(lockId,true);
        }

        if(visited[lockId] == VisitState.VISITING){
            //we looped back to this node while still visiting it, so we know there's a cycle
            return true;
        }else{
            visited[lockId] = VisitState.VISITING;
            for (LockNode n : children) {
                if (n.hasCycle(visited, touchNodes)) {
                    return true;
                }
            }
            visited[lockId] = VisitState.VISITED;
        }
        return false;
    }

    public Lock getLock() {
        if (lock == null) {
            lock = new ReentrantLock();
        }
        return lock;
    }

    public int getId() {
        return lockId;
    }
}
