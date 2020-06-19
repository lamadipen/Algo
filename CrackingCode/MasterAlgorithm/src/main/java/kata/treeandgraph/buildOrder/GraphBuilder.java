package kata.treeandgraph.buildOrder;

public class GraphBuilder {
    public static Graph build(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();

        for (String project : projects) {
            graph.getOrCreate(project);
        }

        for (String[] dependency : dependencies) {
            String start = dependency[0];
            String end = dependency[1];
            graph.addNeighbors(start, end);
        }
        return graph;
    }
}
