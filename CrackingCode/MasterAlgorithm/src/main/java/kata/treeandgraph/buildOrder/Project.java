package kata.treeandgraph.buildOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {
    String name;
    List<Project> children = new ArrayList<>();
    Map<String, Project> map = new HashMap<>();
    int dependencies = 0;

    public Project(String name) {
        this.name = name;
    }

    public void addNeighbour(Project node) {
        if (!map.containsKey(node.name)) {
            map.put(node.name, node);
            children.add(node);
            node.dependencies++;
        }
    }
}
