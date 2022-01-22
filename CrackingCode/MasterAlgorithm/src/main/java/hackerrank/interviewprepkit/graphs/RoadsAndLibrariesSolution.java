package hackerrank.interviewprepkit.graphs;

import java.util.*;

public class RoadsAndLibrariesSolution {
    public static long roadsAndLibraries(int numberOfCities, int costToBuildLib, int costToRepairRoad, List<List<Integer>> cities) {
        // Write your code here
        List<RLNode> nodes = new ArrayList<>();
        for (int i = 1; i <= numberOfCities; i++) {
            RLNode rlNode1 = new RLNode(i);
            nodes.add(rlNode1);
        }
        for (int i = 0; i < cities.size(); i++) {
            Integer n1 = cities.get(i).get(0);
            Integer n2 = cities.get(i).get(1);

            RLNode rlNode1 = nodes.get(n1 - 1);
            RLNode rlNode2 = nodes.get(n2 - 1);
            rlNode1.adj.add(rlNode2);
            rlNode2.adj.add(rlNode1);
        }

        if (costToBuildLib < costToRepairRoad) {
            return numberOfCities * costToBuildLib;
        } else {
            long totalCost = 0;
            long numberOfRoads = 0;
            for (RLNode node : nodes) {
                if (!node.visited) {
                    numberOfRoads += dfs(node);
                    System.out.println("numberOfRoads = " + numberOfRoads);
                    if (node.adj.size() == 0) {
                        totalCost += costToBuildLib;
                    }
                }
            }
            totalCost += numberOfRoads * costToRepairRoad + costToBuildLib;
            return totalCost;
        }
    }

    private static long dfs(RLNode rlNode) {
        if (rlNode.visited) return 0;
        rlNode.visited = true;
        int totalRoads = 0;
        for (RLNode child : rlNode.adj) {
            if (!child.visited) {
                totalRoads += dfs(child) + 1;
            }
        }
        return totalRoads;
    }

    public static long roadsAndLibrariesReferenceSolution(int numberOfCities, int costToBuildLib, int costToRepairRoad, List<List<Integer>> cities) {
        Map<Integer, List<Integer>> cityMap = new HashMap<>();

        for (int i = 1; i <= numberOfCities; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            cityMap.put(i, list);
        }

        for (int i = 0; i < cities.size(); i++) {
            Integer n1 = cities.get(i).get(0);
            Integer n2 = cities.get(i).get(1);

            List<Integer> list1 = cityMap.get(n1);
            List<Integer> list2 = cityMap.get(n2);

            if (list1 != list2) {
                list1.addAll(list2);
                list2.forEach(item -> cityMap.put(item, list1));
            }
        }

        if (costToBuildLib < costToRepairRoad) {
            return (long) numberOfCities * costToBuildLib;
        } else {
            long cost = 0;
            for (List<Integer> list : cityMap.values()) {
                int size = list.size();
                if (size > 0) {
                    cost += costToBuildLib;
                    cost += (size - 1) * costToRepairRoad;
                    list.clear();
                }
            }
            return cost;
        }
    }
}

class RLNode {
    int value;
    int index;
    boolean visited;
    List<RLNode> adj;

    public RLNode(int value) {
        this.value = value;
        adj = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RLNode rlNode = (RLNode) o;
        return value == rlNode.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
