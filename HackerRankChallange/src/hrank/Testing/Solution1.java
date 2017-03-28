package hrank.Testing;

/**
 * Created by dipen on 3/16/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        System.out.println(t);
        String result="";
        for(int i=0;i < t;i++)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(n+" "+k);

            int lateCount =0;
            for(int j=0;j<n;j++)
            {
                int arrivalTime = sc.nextInt();
                System.out.print(arrivalTime+" ");
                if(arrivalTime >0)
                {
                    lateCount++;
                }
            }
            System.out.println();
            if(lateCount >= k)
            {
                result += "Yes\n";
                //System.out.println("YES");
            }
            else{
                //System.out.println("No");
                result +="No\n";
            }

        }
        System.out.println(result);


    }
}
