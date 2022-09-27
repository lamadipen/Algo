package com.shailesh;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonInterviewQuestionSolution {

    public static int test1(List<String> logins){
        Map<String, Integer> map = new HashMap<>();

        for (String login : logins
        ) {
            char[] temp = login.toCharArray();
            Arrays.sort(temp);
            String key = temp.toString();
            map.put(key,map.getOrDefault(key,0)+1);
        }
        int pairCount = 0;

        for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
            Integer value = mapEntry.getValue();
            if (value > 1) {
                pairCount++;
            }
        }
        return pairCount;
    }

}
