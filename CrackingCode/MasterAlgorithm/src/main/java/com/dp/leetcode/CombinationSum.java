package com.dp.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note: All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ... , ak) must be in non-descending order.
 * (ie, a1 <= a2 <= ... <= ak). The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, A solution set is:
 *
 *  Input
 *  [2,3,6,7]
 *
 *  Output
 *  [7]
 *  [2, 2, 3]
 *
 *
 * 7 7 7
 * 2 2 2
 * 3 3 3
 *
 * https://www.programcreek.com/2014/02/leetcode-combination-sum-java/
 */
public class CombinationSum {


    public static  List<List<Integer>> combinationSumSolution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target,0 , 0, temp, result);
        return result;
    }


    public static void helper(int[] candidates, int target, int start, int sum, List<Integer> selectedNumList,List<List<Integer>> result){
        if (sum > target) {
            return;
        }
        //List<Integer> collect = selectedNumList.stream().sorted().collect(Collectors.toList());
        if (sum == target && !result.contains(selectedNumList)) {
            result.add(new ArrayList<>(selectedNumList));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            selectedNumList.add(candidates[i]);
            Collections.sort(selectedNumList);
            helper(candidates, target, i, sum + candidates[i], selectedNumList, result);
            selectedNumList.remove(selectedNumList.size() - 1);
        }
    }


    @Test
    public void combinationSumTest() {
//
//        List<List<Integer>> lists = combinationSumSolution(new int[]{2, 3, 6, 7}, 7);
//        lists.stream().forEach(list -> System.out.println(list));
        List<List<Integer>> lists = combinationSumSolutionNew(new int[]{2, 3, 6, 7}, 7);
        lists.stream().forEach(list -> System.out.println(list));
    }

    private static  List<List<Integer>> combinationSumSolutionNew(int[] candidate, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp =new ArrayList<>();
        helper2(candidate,target, 0,0,temp,result);
        return  result;
    }

    public static  void helper2(int[] candidate, int target, int start, int sum, List<Integer> temp, List<List<Integer>> result) {
        if (sum > target) {
            return;
        }
        if (target == sum && !result.contains(temp)) {
            result.add(temp);
            return;
        }

        for (int i = 0; i < candidate.length; i++){
            temp.add(candidate[i]);
            Collections.sort(temp);
            helper(candidate,target,i,sum+candidate[i],temp,result);
            temp.remove(temp.size() - 1);
        }
    }

}
