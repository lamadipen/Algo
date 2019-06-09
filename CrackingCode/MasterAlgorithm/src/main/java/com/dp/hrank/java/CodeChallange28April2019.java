package com.dp.hrank.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class CodeChallange28April2019 {

    public static void main(String... args) {
//        Question1();
        question2();
    }

    private static void Question1() {
        String str = "40 40 40 40 29 29 29 29 29 29 29 29 57 57 92 92 92 92 92 86 86 86 86 86 86 86 86 86 86";

        StringTokenizer st = new StringTokenizer(str, " ");
        StringBuilder sb = new StringBuilder();
        int previous = Integer.parseInt(st.nextToken());
        int count = 1;

        while(st.hasMoreTokens()){
            int current = Integer.parseInt(st.nextToken());
            if(previous != current){
                sb.append(count).append(" ").append(previous).append(" ");
                previous = current;
                count = 1;

            }else{
                count++;
            }
        }
        sb.append(count).append(" ").append(previous);

        System.out.println(sb.toString());
    }

    private static void question2() {
        List<String> list = new ArrayList<>();
        list.add("Hello World");
        list.add("Califonia");
        list.add("Sanfranscicso califoina");

        list.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
    }

    private static void question3() {

    }
}
