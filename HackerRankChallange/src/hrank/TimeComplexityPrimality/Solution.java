package hrank.TimeComplexityPrimality;

import java.util.Scanner;

/**
 * Created by dipen on 6/1/2017.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            System.out.println(isPrime(n)?"Prime": "Not prime");
        }
    }

    public static boolean isPrime(int n)
    {

        if(n < 2)
        {
            return false;
        }

        for(int i =2; i <= n/2; i++)
        {
            if(n%i == 0)
            {
                return false;
            }
        }
        return true;

    }
}
