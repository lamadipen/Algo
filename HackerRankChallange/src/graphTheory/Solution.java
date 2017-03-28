package graphTheory;

/**
 * Created by dipen on 3/18/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int roadCost =0;
            int [] vis = new int[n];
            List<Integer> visited = new ArrayList<>();
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();



                if(visited.contains(city_2) )
                {
                    System.out.println("Already Visited");
                }
                else
                {
                    //visited.add(city_1);
                    visited.add(city_2);
                    roadCost += y;
                    //System.out.println("Add to list");
                }
                System.out.println(visited.toString());

            }
            int allLibCost = n *x;
            /*
            if(allLibCost < (roadCost+1))
            {
                System.out.println("Library ALL "+allLibCost);
            }
            else{
                System.out.println("Cost of Road"+roadCost);
            }*/
            System.out.println("Cost of Road"+roadCost + "All library"+allLibCost);
        }
    }

    public static void minimumCost()
    {

    }
}
