package kata.treeandgraph.buildOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    List<Project> projects = new ArrayList();
    Map<String, Project> map = new HashMap();

    public Project getOrCreate(String name) {
        if (!map.containsKey(name)) {
            Project p = new Project(name);
            map.put(name, p);
            projects.add(p);
        }
        return map.get(name);
    }

    public void addNeighbors(String startName, String endName) {
        Project start = getOrCreate(startName);
        Project end = getOrCreate(endName);
        start.addNeighbour(end);
    }
}
