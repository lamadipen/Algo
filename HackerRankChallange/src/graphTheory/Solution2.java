package graphTheory;

/**
 * Created by dipen on 3/18/2017.
 */

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int roadCost =0;
            Map<Integer,Boolean> visited = new HashMap<>();

            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();

                if(visited.isEmpty())
                {
                    visited.put(city_1,true);
                    visited.put(city_2,true);
                    roadCost += y;
                }
                else if(visited.containsKey(city_2) )
                {
                    //System.out.println("Already Visited");
                }
                else
                {
                    visited.put(city_2,true);
                    roadCost += y;
                }
                //System.out.println(visited.toString());

            }
            int allLibCost = n *x;

            if(allLibCost < (roadCost+x))
            {
                //System.out.println("Library ALL "+allLibCost);
                System.out.println(allLibCost);
            }
            else{
                //System.out.println("Cost of Road"+roadCost);
                System.out.println(roadCost+x);
            }
            //System.out.println("Cost of Road"+roadCost + "All library"+allLibCost);
        }
    }

    public static void minimumCost()
    {

    }
}
