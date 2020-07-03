package kata.treeandgraph.pathwithsum;

import kata.treeandgraph.TreeNode;

import java.util.HashMap;

/**
 * Path With Sum
 * CC: pg 111 Q: 4.12
 * <p>
 * Two solution is giving different result need to revisit.
 */
public class PathWithSum {

    public int countPathWithSum(TreeNode<Integer> root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int countFromRoot = countPathWithSumFromNode(root, targetSum, 0);
        int countFromLeft = countPathWithSum(root.left, targetSum);
        int countFromRight = countPathWithSum(root.right, targetSum);

        return countFromRoot + countFromLeft + countFromRight;
    }

    private int countPathWithSumFromNode(TreeNode<Integer> node, int targetSum, int currentSum) {
        if (node == null) return 0;

        int pathCount = 0;
        currentSum += node.data;
        if (targetSum == currentSum) {
            pathCount++;
        }

        pathCount += countPathWithSumFromNode(node.left, targetSum, currentSum);
        pathCount += countPathWithSumFromNode(node.left, targetSum, currentSum);

        return pathCount;
    }

    public int countPathWithSumOptimized(TreeNode<Integer> root, int targetSum) {
        if (root == null) return 0;
        return countPathWithSumOptimized(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    private int countPathWithSumOptimized(TreeNode<Integer> node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null) return 0;
        runningSum += node.data;
        int sum = runningSum - targetSum;
        int totalPath = pathCount.getOrDefault(sum, 0);

        if (targetSum == runningSum) {
            totalPath++;
        }

        incrementalHashMap(pathCount, runningSum, 1);
        totalPath += countPathWithSumOptimized(node.left, targetSum, runningSum, pathCount);
        totalPath += countPathWithSumOptimized(node.right, targetSum, runningSum, pathCount);
        incrementalHashMap(pathCount, runningSum, -1);
        return totalPath;
    }

    private void incrementalHashMap(HashMap<Integer, Integer> pathCount, int key, int delta) {
        int newCount = pathCount.getOrDefault(key, 0) + delta;

        if (newCount == 0) {
            pathCount.remove(key);
        } else {
            pathCount.put(key, newCount);
        }
    }
}
