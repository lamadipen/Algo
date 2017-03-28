package hrank.BitwiseExample;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;

/**
 * Created by dipen on 3/13/2017.
 */
public class Challange {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int largest = 0;
            for(int i=1; i <= n; i++)
            {
                for(int j=i+1;j <=n; j++)
                {
                    int tmp = i & j;
                    if(tmp > largest && tmp < k)
                    {
                        largest=tmp;
                        //System.out.println(i+" "+j+" temp "+ largest);
                    }
                }
            }
            System.out.println(largest);
        }







    }
}
