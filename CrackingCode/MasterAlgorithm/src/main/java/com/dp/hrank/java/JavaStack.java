package com.dp.hrank.java;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        Stack<String> open = new Stack<String>();

        while (sc.hasNext()) {
            String input = sc.next();
            if (input.equals("(") || input.equals("{") || input.equals("}"))
                open.add(input);
            else
                if(input.equals(")")){
                    open.pop().equals("(");
                } else if (input.equals("}")) {
                    open.pop().equals("{");
                } else {
                    open.pop().equals("]");
                }
        }

    }
}
