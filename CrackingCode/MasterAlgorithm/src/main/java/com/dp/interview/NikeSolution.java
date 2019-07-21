package com.dp.interview;

import java.util.HashMap;
import java.util.Map;

public class NikeSolution {

    public static void main(String[] args) {
        System.out.println(solutionDay("Wed", 2)); // fri
        System.out.println(solutionDay("Wed", 23)); //Mon
        System.out.println(solutionDayHashMap("Wed", 2)); //Mon
        System.out.println(solutionDayHashMap("Wed", 23)); //Mon
    }

    /**
     * days of the week are represented as three letter strings mon tue wed thu fri sat sun
     */
    public static String solutionDay(String S, int K) {
//        System.out.println(LocalDate.now().getDayOfWeek());
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int dayIndex = -1;
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(S)) {
                dayIndex = i;
            }
        }

        int laterDays = K % 7;
        int laterDayIndex = (dayIndex + laterDays) % 7;
        return days[laterDayIndex];
    }

    public static String solutionDayHashMap(String S, int K) {
        Map<String, Integer> days = new HashMap();
        days.put("Mon", 0);
        days.put("Tue", 1);
        days.put("Wed", 2);
        days.put("Thu", 3);
        days.put("Fri", 4);
        days.put("Sat", 5);
        days.put("Sun", 6);

        int startDayPos = days.get(S);
        int finalDayPos = (startDayPos + K % 7) % 7;


        String result = "";
        for (Map.Entry<String, Integer> entry : days.entrySet()) {
            if (entry.getValue() == finalDayPos) {
                result = entry.getKey();
                break;
            }
        }
        return result;

    }

    /**
     * there is a board with 2 rows and n columns codility
     */
    public String solution(int U, int L, int[] C) {
        /* arr  = [1 1 0 1 0
                   1 0 0 0 1 ]
           U = 3
           L = 2
           then print
           1,1,0,1,0 - 1,0,0,0,1

        * */
        // write your code in Java SE 8

//
//        for(int i =0 ; i < )
//
        return "";
    }


}
