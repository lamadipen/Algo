package hrank.Testing;

import java.util.Random;

/**
 * Created by dipen on 3/16/2017.
 */
public class Solution2 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Random random = new Random();
        //Scanner sc = new Scanner(System.in);
        //int t = sc.nextInt();
        int t = random.nextInt(6); //classes
        System.out.println(t);
        String result="";
        for(int i=0;i < t;i++)
        {
            //int n = sc.nextInt();
            //int k = sc.nextInt();
            int n = random.nextInt(200-3+1)+3; //students
            int k = random.nextInt(n)+1; //threshold
            System.out.println(n+" "+k);

            int lateCount =0;
            for(int j=0;j<n;j++)
            {
                //int arrivalTime = sc.nextInt();
                int arrivalTime = random.nextInt(1000 +1 +1000)-1000;
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
