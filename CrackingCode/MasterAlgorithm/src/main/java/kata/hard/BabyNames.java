package kata.hard;

import java.util.*;

/**
 * Hard
 * Baby Names
 * CC: pg 187 Q: 17.7
 */
public class BabyNames {
    /**
     * Runtime O(nlogn)
     */
    Map<String, Integer> trulyMostPopular(Map<String, Integer> names, String[][] synonyms) {
        Map<String, Nameset> groups = constructGroups(names);
        mergeClasses(groups, synonyms);

        return convertToMap(groups);
    }

    private Map<String, Integer> convertToMap(Map<String, Nameset> groups) {
        HashMap<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Nameset> entry : groups.entrySet()) {
            Nameset ns = entry.getValue();
            result.put(ns.rootName, ns.frequency);
        }
        return result;
    }

    private void mergeClasses(Map<String, Nameset> groups, String[][] synonyms) {
        for (String[] entry : synonyms) {
            String name1 = entry[0];
            String name2 = entry[1];
            Nameset set1 = groups.get(name1);
            Nameset set2 = groups.get(name2);

            if ((null != set2 && null != set1) && set1 != set2) {
                Nameset small = set1.frequency < set2.frequency ? set1 : set2;
                Nameset big = set1.frequency < set2.frequency ? set2 : set1;

                Set<String> names = small.names;
                big.copyNamesWithFrequency(names, small.frequency);

                for (String name : names) {
                    groups.put(name, big);
                }
            }
        }
    }

    private Map<String, Nameset> constructGroups(Map<String, Integer> names) {
        Map<String, Nameset> groups = new HashMap<>();
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            String name = entry.getKey();
            Integer freq = entry.getValue();

            Nameset ns = new Nameset(name, freq);
            groups.put(name, ns);
        }
        return groups;
    }

    /**
     * Runtime O(M + N) where M is number of names and N is number of pair of synonyms
     */
    Map<String, Integer> trulyMostPopularOptimized(Map<String, Integer> names, String[][] synonyms) {
        Graph graph = buildGraph(names);
        connectEdges(graph, synonyms);

        return calculateTotalFrequency(graph);
    }

    private Map<String, Integer> calculateTotalFrequency(Graph graph) {
        Map<String, Integer> rootNames = new HashMap<>();

        for (Node node : graph.nodes) {
            if (!node.visited) {
                int totalFreq = aggregateFreqForNode(node);
                String rootName = node.Name;
                rootNames.put(rootName, totalFreq);
            }
        }
        return rootNames;
    }

    private int aggregateFreqForNode(Node node) {
        if (node.visited) {
            return 0;
        }
        node.visited = true;
        int totalFreq = node.frequency;

        for (Node neighbor : node.adjacentList) {
            totalFreq += aggregateFreqForNode(neighbor);
        }
        return totalFreq;
    }

    private Graph buildGraph(Map<String, Integer> names) {
        Graph graph = new Graph();
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            String name = entry.getKey();
            Integer freq = entry.getValue();
            graph.addNodes(name, freq);
        }
        return graph;
    }

    private void connectEdges(Graph graph, String[][] synonyms) {
        for (String[] synonym : synonyms) {
            String name1 = synonym[0];
            String name2 = synonym[1];
            graph.addEdge(name1, name2);
        }
    }
}

class Nameset {
    Set<String> names = new HashSet<String>();
    int frequency = 0;
    String rootName;

    public Nameset(String rootName, int frequency) {
        names.add(rootName);
        this.rootName = rootName;
        this.frequency = frequency;
    }

    public void copyNamesWithFrequency(Set<String> more, int freq) {
        names.addAll(more);
        frequency += freq;
    }
}

class Graph {
    List<Node> nodes;
    Map<String, Node> cache;

    public Graph() {
        this.nodes = new ArrayList<>();
        this.cache = new HashMap<>();
    }

    public Node addNodes(String name, Integer freq) {
        if (cache.containsKey(name)) {
            return null;
        }
        Node node = new Node(name, freq);
        cache.put(name, node);
        nodes.add(node);
        return node;
    }

    public void addEdge(String name1, String name2) {
        Node node1 = cache.get(name1);
        Node node2 = cache.get(name2);

        if (null != node1 && null != node2) {
            node1.addNeighbours(node2);
            node2.addNeighbours(node1);
        }
    }
}

class Node {
    String Name;
    int frequency;
    List<Node> adjacentList = new ArrayList<>();
    boolean visited = false;

    public Node(String name, int frequency) {
        Name = name;
        this.frequency = frequency;
    }


    public void addNeighbours(Node neighbor) {
        adjacentList.add(neighbor);
    }
}
