package hrank.ArrayManipulation;

import java.util.*;

/**
 * Created by dipen on 3/2/2018.
 */
public class Solution {

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer> myList = new ArrayList<>();

        for(int i= 0; i < n;i++){
            myList.add(0);
        }

        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            for(int j=a-1;j < b-1; j++){
                myList.set(j,k+(myList.get(j)));
            }
        }

        int val = myList.stream().max(Comparator.comparing(item -> item)).get();
        System.out.println(val);
        in.close();
    }
*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
       int [] myList = new int[n];

        for(int i= 0; i < n;i++){
            myList[i]=0;
        }

        /*for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
           // myList[a-1] =k;

            System.out.println(myList[a-1]-=k);
            System.out.println(myList[a-1]);
            break;
            *//*if(b <n){
                myList.set() =
            }*//*
        }*/

        //int val = Arrays.asList(myList).stream().max(Comparator.comparing(item -> item)).get();
        //System.out.println(val);
        in.close();


        int [] test = {0,5,1};
        test[2]=-1;
        test[1]-=2;
        System.out.println(test[2]);
        System.out.println(test[1]);


    }
}
/**
5 3
1 2 100
2 5 100
3 4 100
 **/