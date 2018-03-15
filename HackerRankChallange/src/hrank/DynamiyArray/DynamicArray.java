package hrank.DynamiyArray;

import java.util.*;

/**
 * Created by dipen on 3/1/2018.
 */
public class DynamicArray {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int no_of_seq = sc.nextInt();
        int lastAnswer = 0;

        List<Integer> [] seqList = new ArrayList[n];
        for(int i=0; i < n; i++){
            seqList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i < no_of_seq; i++){
            int queryNum = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int index = (x^lastAnswer)%n;
            if(queryNum == 1){
                seqList[index].add(y);
            }else{
                lastAnswer = seqList[index].get(y%seqList[index].size()) ;
                System.out.println(lastAnswer);
            }
        }

       /* List<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>(n);

        for(int i=0; i < n; i++){
            seqList.add(new ArrayList<Integer>());
        }

        for(int i=0; i < no_of_seq; i++){
            int queryNum = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int index = (x^lastAnswer)%n;
            if(queryNum == 1){
                seqList.get(index).add(y);
            }else{
                lastAnswer = seqList.get(index).get(y%n) ;
                System.out.println(lastAnswer);
            }

        }*/
    }

    /*
    solution from net
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int lastans =0;
    int N = sc.nextInt();
    int Q = sc.nextInt();
    int tag, x, y, index;

    ArrayList<Integer>[] list = new ArrayList[N];

    while(Q-->0){
        tag = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        index = (x^lastans)%N;

        switch (tag) {

            case 1:
                if (list[index] == null) {
                    ArrayList<Integer> myList = new ArrayList<>();
                    myList.add(y);
                    list[index] = myList;
                } else
                    list[index].add(y);
                break;
            case 2:
                System.out.println(lastans = list[index].get(y % list[index].size()));
                break;
        }
    }
    }
     */
}

/*
2 5
1 0 5
1 1 7
1 0 3
2 1 0
2 1 1*/

