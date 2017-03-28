package hrank.algo;

/**
 * Created by dipen on 2/19/2017.
 */
import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class ArrayLeftRotation {

   /* solution using array and double loop time consuming
   public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int[] temp = new int[n];
        int counter=0;

        while(counter <k)
        {
            *//*int firstValue = a[0];

            for(int i=0;i<n;i++)
            {
                if(n > i+1){
                    temp[i] = a[i+1];
                }
            }
            temp[n-1] = firstValue;
            a =temp;*//*


            System.out.println("temp: "+Arrays.toString(a));
            counter++;

        }
        System.out.println(Arrays.toString(temp));
        return temp;
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
    //Solution using arrayList
    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        List<Integer> temp = new ArrayList<>(n);
        int counter=0;

        for (int val: a) {
            temp.add(val);
        }

        while(counter <k)
        {
            int firstValue = temp.get(0);
            temp.remove(0);
            temp.add(firstValue);
            counter++;
        }
        System.out.println("temp: "+temp.toString());
        for (int i = 0; i < temp.size(); i++) {
            a[i] = temp.get(i);
        }
        return a;
    }
}
