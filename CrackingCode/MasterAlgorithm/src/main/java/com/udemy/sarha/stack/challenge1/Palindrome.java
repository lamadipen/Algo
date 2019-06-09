package com.udemy.sarha.stack.challenge1;

import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
        Stack<Character> stack = new Stack<>();
        StringBuilder initialString = new StringBuilder();


        for(int i = 0; i < string.length(); i++){
            char item = string.toLowerCase().charAt(i);
            if(item >= 'a' && item <= 'z' ){
                stack.push(item);
                initialString.append(item);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString().equals(initialString.toString().toLowerCase());
    }
}
