package realcodetest.amazon.shailesh;

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
            String key = String.valueOf(temp);
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

    public static int countFamilyLogins(List<String> logins) {

        Map<String, Integer> map = new HashMap<>();

        for (String s : logins) {
            System.out.println("map Count ----" +s);
            map.put(s,map.getOrDefault(s, 0)+1);
        }

        int pairCount =0;

        for(Map.Entry<String, Integer> mEntry : map.entrySet()){
            String key = mEntry.getKey();
            char[] chars = key.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                int modified = chars[i] +1;
                if(modified == 122){
                    chars[i] = (char)97;
                }else{
                    chars[i] = (char)modified;
                }
            }
            String newOne = String.valueOf(chars);

            System.out.println("new One ----" +newOne);

            if(map.getOrDefault(newOne, 0) > 0){
                pairCount += mEntry.getValue();
            }
        }
        return pairCount;

    }
}
