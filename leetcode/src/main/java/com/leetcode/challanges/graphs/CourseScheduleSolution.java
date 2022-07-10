package com.leetcode.challanges.graphs;

import java.util.*;

/**
 * Course Schedule
 * https://leetcode.com/problems/course-schedule/
 * */
public class CourseScheduleSolution {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //key -> course, value -> List of dependent course
        Map<Integer, List<Integer>> coursePreresequitMap = new HashMap<>();
        HashSet<Integer> visiting = new HashSet<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            if(coursePreresequitMap.containsKey(course)){
                coursePreresequitMap.get(course).add(prerequisite);
            }else {
                ArrayList<Integer> prerequisitList = new ArrayList<>();
                prerequisitList.add(prerequisite);
                coursePreresequitMap.put(course,prerequisitList);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if(!dfs(i, coursePreresequitMap,visiting)){
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(int course, Map<Integer, List<Integer>> coursePreresequitMap, HashSet<Integer> visiting) {
        if(visiting.contains(course)) return false;
        if(coursePreresequitMap.get(course) == null || coursePreresequitMap.get(course).isEmpty()) return true;

        visiting.add(course);

        for (Integer prerequsite: coursePreresequitMap.get(course)) {
            if(!dfs(prerequsite,coursePreresequitMap,visiting)){
                return false;
            }
        }
        visiting.remove(course);
        coursePreresequitMap.put(course,Collections.emptyList());
        return  true;
    }

}
