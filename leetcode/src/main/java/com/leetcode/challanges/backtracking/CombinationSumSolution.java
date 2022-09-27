package com.leetcode.challanges.backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Combination Sum
 * https://leetcode.com/problems/combination-sum/
 *
 * https://www.youtube.com/watch?v=GBKI9VSKdGg
 * */
public class CombinationSumSolution {
    /**
     * Runtime O(2^t) where t is size of target
     * */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        Stack<Integer> current = new Stack<>();
        dfs(0,current,0,candidates,target, result);
        return result;
    }

    private static void dfs(int index, Stack<Integer> current, int total, int[] candidates, int target, List<List<Integer>> result) {
        if(target == total){
            result.add(current.stream().collect(Collectors.toList()));
            return;
        }
        if (index >= candidates.length || total > target) {
            return;
        }
        current.add(candidates[index]);
        dfs(index,current,total+candidates[index],candidates,target,result);
        current.pop();
        dfs(index+1,current,total,candidates,target,result);
    }
}

