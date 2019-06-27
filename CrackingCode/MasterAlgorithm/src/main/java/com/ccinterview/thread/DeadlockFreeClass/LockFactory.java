package com.ccinterview.thread.DeadlockFreeClass;

import java.util.HashMap;
import java.util.LinkedList;

public class LockFactory {
    private static LockFactory instance;

    private int numberOfLocks = 5;

    private LockNode[] locks;

    //Maps from a process or owner to the order that the owner claimed it would call the lock in
    private HashMap<Integer, LinkedList<LockNode>> lockOrder;

    private LockFactory(int count){

    }

    public static LockFactory getInstance() {
        return instance;
    }

    public static synchronized LockFactory initialize(int count) {
        if(instance == null) instance = new LockFactory(count);
        return instance;
    }

    public boolean hasCycle(HashMap<Integer, Boolean> touchNodes, int[] resourcesInOrder) {
        return false;
    }
}
