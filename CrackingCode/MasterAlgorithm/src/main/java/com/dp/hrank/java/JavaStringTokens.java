package com.dp.hrank.java;

import java.util.Scanner;
import java.util.stream.Stream;

public class JavaStringTokens {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        s = s.trim();
        if (s.length()>400000){
            return ;
        }
        if(s.length()==0){
            System.out.println("0");
        }
        String delims = "[ .,?!']+";
        String[] tokens = s.split(delims);

        System.out.println(tokens.length);

        Stream.of(tokens).forEach(System.out::println);
        sc.close();
    }

    public static void workingSolution() {
        Scanner scan = new Scanner(System.in);
        String s=scan.nextLine();
        //Complete the code
        s = s.trim();
        if (s.length()>400000){
            return ;
        }else if (s.length()==0){
            System.out.println(0);
            return ;
        }else{
            String[] words = s.split("[!,?.*_'@\\ ]+");
            int count = words.length;
            System.out.println(count);
            for(String word : words){
                System.out.println(word);
            }
        }

    }
}


/**
 Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens. We define a token to be one or more consecutive English alphabetic letters. Then, print the number of tokens, followed by each token on a new line.

 Note: You may find the String.split method helpful in completing this challenge.

 Input Format

 A single string, .

 Constraints

 is composed of any of the following: English alphabetic letters, blank spaces, exclamation points (!), commas (,), question marks (?), periods (.), underscores (_), apostrophes ('), and at symbols (@).
 Output Format

 On the first line, print an integer, , denoting the number of tokens in string  (they do not need to be unique). Next, print each of the  tokens on a new line in the same order as they appear in input string .

 Sample Input

 He is a very very good boy, isn't he?
 Sample Output

 10
 He
 is
 a
 very
 very
 good
 boy
 isn
 t
 he
 Explanation

 We consider a token to be a contiguous segment of alphabetic characters. There are a total of  such tokens in string , and each token is printed in the same order in which it appears in string .

 */