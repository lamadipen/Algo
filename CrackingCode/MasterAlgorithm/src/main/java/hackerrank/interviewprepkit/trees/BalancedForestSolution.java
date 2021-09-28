package hackerrank.interviewprepkit.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Interview Preparation Kit | Trees | Tree : Balanced Forest
 */
public class BalancedForestSolution {
    //collects sums of nodes that are still in the stack of the recursive calls
    static Set<Long> foundSum = new HashSet<>();

    //collects sums of nodes that were left behind from the recursive calls
    static Set<Long> leftBehindSum = new HashSet<>();

    static long total = 0;

    static long min = Long.MAX_VALUE;

    public static int balancedForest(List<Integer> nodes, List<List<Integer>> edges) {
        foundSum = new HashSet<>();
        leftBehindSum = new HashSet<>();

        //take first node as root, the tree is bidirectional
        BFNode root = buildTree(nodes, edges);

        //calculate sums of childs "under" every node
        total = dfs(root);
        min = total;
        //traverse the "tree" again and compare findings with current node or those that were left behind
        solve(root);
        return min == total ? -1 : (int) min;
    }

    private static void solve(BFNode node) {
        if (node.v2) return;
        node.v2 = true;

        long remainingSum = total - node.sum;
        long possibleMin = remainingSum / 2 - node.sum;

        //assuming current node is the smallest subtree that can be produced, explore options to validate that assumption
        if (remainingSum % 2 == 0
                && (leftBehindSum.contains(remainingSum / 2)
                || foundSum.contains(remainingSum / 2 + node.sum)
        ) && possibleMin >= 0) {
            min = Math.min(min, possibleMin);
        }

        //assuming current node is one of the two equal subtrees that can be produced, explore options to validate that assumption
        possibleMin = node.sum - (total - node.sum * 2);
        if ((leftBehindSum.contains(node.sum)
                || leftBehindSum.contains(total - node.sum * 2)
                || foundSum.contains(node.sum * 2)
                || foundSum.contains(total - node.sum)
        ) && possibleMin >= 0) {
            min = Math.min(min, possibleMin);
        }

        foundSum.add(node.sum);
        for (BFNode next : node.adjacents) {
            solve(next);
        }
        ;
//        System.out.println("Removing from foundSum and adding to left behind" +node.id);
        foundSum.remove(node.sum);
        leftBehindSum.add(node.sum);
    }

    private static long dfs(BFNode node) {
        if (node.visited) return 0;
        node.visited = true;

        for (BFNode next : node.adjacents) {
            if (!next.visited) {
                node.sum += dfs(next);
            }
        }
        node.sum += node.value;
        return node.sum;
    }

    private static BFNode buildTree(List<Integer> nodesList, List<List<Integer>> edges) {
        List<BFNode> nodes = new ArrayList();

        for (int i = 0; i < nodesList.size(); i++) {
            BFNode node = new BFNode();
            node.value = nodesList.get(i);
            node.id = i + 1;
            nodes.add(node);
        }

        for (int i = 0; i < edges.size(); i++) {
            BFNode a = nodes.get(edges.get(i).get(0) - 1);
            BFNode b = nodes.get(edges.get(i).get(1) - 1);
            a.adjacents.add(b);
            b.adjacents.add(a);
        }
        return nodes.get(0);
    }

/** Working solution as reference
 static class Node {
 long sum;
 int value;
 int id;
 boolean visited, v2;
 Set<Node> adjacents = new HashSet();

 @Override public int hashCode() {
 return id;
 }
 }

 static long total = 0;
 static long min = Long.MAX_VALUE;

 //collects sums of nodes that are still in the stack of the recursive calls
 static Set<Long> foundSum = new HashSet<>();
 //collects sums of nodes that were left behind from the recursive calls
 static Set<Long> leftBehindSum = new HashSet<>();

 public static long balancedForest(List<Integer> c, List<List<Integer>> edges) {
 // Write your code here

 foundSum = new HashSet<>();
 leftBehindSum = new HashSet<>();

 List<Node> nodes = new ArrayList();
 for (int i = 0; i < c.size(); i++) {
 Node node = new Node();
 node.value = c.get(i);
 node.id = i + 1;
 nodes.add(node);
 }
 for (int i = 0; i < edges.size(); i++) {
 Node a = nodes.get(edges.get(i).get(0) - 1);
 Node b = nodes.get(edges.get(i).get(1) - 1);
 a.adjacents.add(b);
 b.adjacents.add(a);
 }

 //take first node as root, the tree is bidirectional
 Node root = nodes.get(0);
 //calculate sums of childs "under" every node
 total = dfs(root);
 min = total;

 //traverse the "tree" again and compare findings with current node or those that were left behind
 solve(root);
 return (min == total ? -1 : min);
 }

 static void solve(Node node) {
 if (node.v2) return;
 node.v2 =true;

 long leftForTwo = total - node.sum;
 long possibleMin = leftForTwo/2 - node.sum;

 //assuming current node is the smallest subtree that can be produced, explore options to validate that assumption
 if (leftForTwo % 2 == 0
 && (leftBehindSum.contains(leftForTwo/2)
 || foundSum.contains(leftForTwo/2+node.sum)
 ) && possibleMin >= 0) {
 min = Math.min(min, possibleMin);
 }

 //assuming current node is one of the two equal subtrees that can be produced, explore options to validate that assumption
 possibleMin = node.sum - (total - node.sum * 2);
 if ((leftBehindSum.contains(node.sum)
 || leftBehindSum.contains(total - node.sum * 2)
 || foundSum.contains(node.sum * 2)
 || foundSum.contains(total - node.sum)
 )&& possibleMin >= 0) {
 min = Math.min(min, possibleMin);
 }


 foundSum.add(node.sum);
 for(Node next : node.adjacents) {
 solve(next);
 };
 foundSum.remove(node.sum);
 leftBehindSum.add(node.sum);
 }

 static long dfs(Node node) {
 if (node.visited) return 0;
 node.visited = true;
 for (Node next : node.adjacents) {
 if (!next.visited) {
 node.sum += dfs(next);
 }
 }
 node.sum += node.value;
 return node.sum;
 }
 */
}

class BFNode {
    long sum;
    int value;
    int id;
    boolean visited, v2;
    Set<BFNode> adjacents = new HashSet();

    @Override
    public int hashCode() {
        return id;
    }
}