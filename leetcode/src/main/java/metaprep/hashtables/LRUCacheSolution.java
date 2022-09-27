package metaprep.hashtables;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCacheSolution {

    // Add any helper functions you may need here
    int maxSize;
    Map<Integer, Integer> cache = new HashMap();
    Queue<Integer> tracker = new LinkedList<>();
    public LRUCacheSolution(int capacity) {
        // Write your code here
        maxSize = capacity;
    }

    public int get(int key) {
        Integer result = cache.getOrDefault(key, -1);
        tracker.remove(key);
        tracker.add(key);
        return result;
    }

    public int set(int key, int value) {
        if(cache.size() == maxSize){
            int toDelete = tracker.poll();
            cache.remove(toDelete);
        }
        cache.put(key,value);
        tracker.add(key);
        return key;
    }

}
