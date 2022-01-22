package hackerrank.interviewprepkit.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Interview Preparation Kit | Graphs | FindTheNearestClone
 */

public class FindTheNearestCloneSolution {
    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        ColorNode[] colorNodes = new ColorNode[graphNodes];
        ColorNode source = null;
        ColorNode destination = null;

        for (int i = 1; i <= graphNodes; i++) {
            ColorNode cNode = new ColorNode();
            cNode.index = i;
            cNode.color = ids[i - 1];
            colorNodes[i - 1] = cNode;
            if (source == null && cNode.color == val) {
                source = cNode;
            }

            if (destination == null && cNode.color == val && source.index != cNode.index) {
                destination = cNode;
            }
        }

        for (int i = 0; i < graphFrom.length; i++) {
            ColorNode cNodeFrom = colorNodes[graphFrom[i] - 1];
            ColorNode cNodeTo = colorNodes[graphTo[i] - 1];
            cNodeFrom.adjacent.add(cNodeTo);
            cNodeTo.adjacent.add(cNodeFrom);
        }

        int shortestPath = graphNodes;

        return bfs(source, destination);
    }

    private static int bfs(ColorNode source, ColorNode destination) {
        Queue<ColorNode> queue = new LinkedList();
        source.visited = true;

        queue.add(source);
        int pathCount = -1;
        while (queue.size() != 0) {
            ColorNode node = queue.poll();
            for (int i = 0; i < node.adjacent.size(); i++) {
                if (!node.adjacent.get(i).visited) {
                    node.adjacent.get(i).visited = true;
                    queue.add(node.adjacent.get(i));
                }
            }
        }
        return pathCount;
    }

    private static ArrayList<Integer>[] adjacencies;
    private static boolean[] visited;

    static int findShortestReference(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        adjacencies = new ArrayList[graphNodes + 1];
        adjacencies[0] = new ArrayList<Integer>();
        visited = new boolean[graphNodes + 1];

        int numCorrectColors = 0;
        for (int i = 1; i <= graphNodes; i++) {
            adjacencies[i] = new ArrayList<>();
            if (ids[i - 1] == val) {
                numCorrectColors++;
            }
        }

        if (numCorrectColors < 2) {
            return -1;
        }

        for (int i = 0; i < graphFrom.length; i++) {
            int node1 = graphFrom[i];
            int node2 = graphTo[i];
            adjacencies[node1].add(node2);
            adjacencies[node2].add(node1);
        }

        int shortestPath = graphNodes;

        for (int i = 1; i < adjacencies.length; i++) {
            long currentNodeColor = ids[i - 1];
            int currentPath = 0;

            if (currentNodeColor != val) {
                continue;
            }

            currentPath += findPathLength(i, val, ids);
            shortestPath = Math.min(shortestPath, currentPath);
        }
        return shortestPath;
    }

    private static int findPathLength(int colorNode, int color, long[] ids) {
        visited[colorNode] = true;
        ArrayList<Integer> adjacency = adjacencies[colorNode];
        int minPath = ids.length;

        for (int i = 0; i < adjacency.size(); i++) {
            int currentNeighbor = adjacency.get(i);
            int currPath = 1;

            if (visited[currentNeighbor]) {
                continue;
            }

            if (ids[currentNeighbor - 1] == color) {
                return currPath;
            }
            currPath += findPathLength(currentNeighbor, color, ids);
            minPath = Math.min(minPath, currPath);
        }

        return minPath;
    }

}

class ColorNode {
    int index;
    long color;
    boolean visited;
    List<ColorNode> adjacent;

    public ColorNode() {
        adjacent = new ArrayList<>();
    }
}
