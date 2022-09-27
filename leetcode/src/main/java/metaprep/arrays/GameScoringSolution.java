package metaprep.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
/**
 * https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 * https://dev.to/santispavajeau/simplest-permutations-k7l
 * https://dev.to/santispavajeau/some-simple-tips-for-combination-sum-backtracking-2924
 * */
public class GameScoringSolution {

    public static int[][] gameScoring(int score) {
        // Write your code here
        int[] waysToScore = new int[]{1,2,3};
        List<List<Integer>> result = new ArrayList();
        Stack<Integer> currentPath = new Stack<>();

        calculateScore(0,score,currentPath,0,waysToScore,result);

        return new int[0][0];
    }

    public static void calculateScore(int currentScore, int targetScore,Stack<Integer> currentPath,int index, int[] waysToScore ,List<List<Integer>> result){
        if (currentScore == targetScore) {
            result.add(currentPath.stream().collect(Collectors.toList()));
            return;
        }
        if (currentScore > targetScore || index >= waysToScore.length-1) {
            return;
        }

        currentPath.add(waysToScore[index]);
        calculateScore(currentScore + waysToScore[index],targetScore,currentPath,index,waysToScore,result);
        currentPath.pop();
        calculateScore(currentScore ,targetScore,currentPath,index+1,waysToScore, result);
    }

    public static int[][] gameScoringV2(int score) {
        // Write your code here
        int[] points = new int[]{1,2,3};
        List<List<Integer>> result = new ArrayList();
        Stack<Integer> currentPoints = new Stack<>();

        dfs(score,points,0,currentPoints,result);

        int[][] finalResult = new int[result.size()][result.get(0).size()];
        for (int row = 0; row < result.size(); row++) {
           List<Integer> temp = result.get(row);
           int[] arr = new int[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                arr[i] = temp.get(i);
            }
            finalResult[row] = arr;
        }

        return finalResult;
    }

    public static void dfs(int score,int[] points,int currentScore,Stack<Integer> currentPoints,List<List<Integer>> result){
        if(currentScore == score){
//            result.add(currentPoints.stream().collect(Collectors.toList()));
            List<Integer> list = new ArrayList();
            for(int value: currentPoints){
                list.add(value);
            }
            result.add(list);
            return;
        }
        if(currentScore > score){
            return;
        }

        for (int point: points) {
            currentPoints.add(point);
            dfs(score,points,currentScore+ point,currentPoints,result);
            currentPoints.pop();
        }
    }

}
