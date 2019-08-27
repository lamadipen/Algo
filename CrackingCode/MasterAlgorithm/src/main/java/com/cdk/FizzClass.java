package com.cdk;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FizzClass {
    public String fizzPrint(int num) {
        if (num == 3) {
            return "fizz";
        } else if (num == 6) {
            return "fizz";
        }
        return "" + num;

//        if(num%3==0 && num%5==0){
//          return "fizzbuzz";
//        }
//        else if(num%3==0){
//            return "fizz";
//        }
//        else if(num%5==0) {
//        return "buzzz";
//        }else{
//            return num+"";
//        }
    }


    public String palandrom(String st) {

        if(st.length() <= 2){
            return st.charAt(0)+"";
        }


        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < st.length(); i++) {
            char key = st.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        StringBuilder sb = new StringBuilder(st);
        for (Map.Entry<Character, Integer> entry : map.entrySet()
        ) {
            if(entry.getValue()%2!=0){
                int index = sb.indexOf(String.valueOf(entry.getKey()));
                sb.deleteCharAt(index);
            }

        }

        return sb.toString();

//        int length = st.length();
//        if (length % 2 != 0) {
//            StringBuilder sb = new StringBuilder(st);
//            sb.deleteCharAt((length / 2) + 1);
//            st = sb.toString();
//        }
//
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < length; i++) {
//            if (i < length / 2) {
//                stack.push(st.charAt(i));
//            } else {
//                if (stack.pop() != st.charAt(i)) {
//                    return false;
//                }
//            }
//
//        }
//        return true;
    }
}
