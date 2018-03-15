package hrank.LeftRotation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by dipen on 2/28/2018.
 */
public class LeftRotation {
    static int[] leftRotation(int[] a, int d) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i < a.length;i++){
            queue.add(a[i]);
        }

         while(d > 0){
         int value = queue.remove();
         queue.add(value);
         d--;
         }
        int [] tmpArr = new int[a.length];
        for (int i=0; i < a.length; i++) {
            tmpArr[i] = queue.remove();
        }

        return tmpArr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
