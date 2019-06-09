package com.dp.hrank.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaArraylist {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int transaction = sc.nextInt();
        List<List<Integer>> mainList = new ArrayList();

        while(transaction > 0){
            int listSize = sc.nextInt();
            List<Integer> list = new ArrayList();
            for(int i = 0; i < listSize; i++){
                list.add(sc.nextInt());
            }
            mainList.add(list);
            transaction--;
        }

        int queryNumber = sc.nextInt();

        while(queryNumber > 0){
            int index = sc.nextInt() - 1;
            List<Integer> temp = mainList.get(index);
            try{
                System.out.println(temp.get(sc.nextInt() -1 ));
            }catch(Exception ex){
                System.out.println("ERROR!");
            }
            queryNumber--;

        }


    }
}

/**
 //TODO solve the challange using 2 Dimension Array

 Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. Try to solve this problem using Arraylist.

 You are given  lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in  position of  line.

 Take your input from System.in.

 Input Format
 The first line has an integer . In each of the next  lines there will be an integer  denoting number of integers on that line and then there will be  space-separated integers. In the next line there will be an integer  denoting number of queries. Each query will consist of two integers  and .

 Constraints

 Each number will fit in signed integer.
 Total number of integers in  lines will not cross .

 Output Format
 In each line, output the number located in  position of  line. If there is no such position, just print "ERROR!"

 Sample Input

 5
 5 41 77 74 22 44
 1 12
 4 37 34 36 52
 0
 3 20 22 33
 5
 1 3
 3 4
 3 1
 4 3
 5 5
 Sample Output

 74
 52
 37
 ERROR!
 ERROR!

 */