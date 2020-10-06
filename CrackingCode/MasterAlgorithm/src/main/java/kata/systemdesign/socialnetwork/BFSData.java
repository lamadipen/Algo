package kata.systemdesign.socialnetwork;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFSData {
    Queue<PathNode> toVisit = new LinkedList<>();
    HashMap<Integer, PathNode> visited = new HashMap<>();

    public BFSData(Person root) {
        PathNode sourcePath = new PathNode(root, null);
        toVisit.add(sourcePath);
        visited.put(root.id, sourcePath);
    }

    public boolean isFinished() {
        return toVisit.isEmpty();
    }
}
