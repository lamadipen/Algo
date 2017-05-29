package algorithm.warmup;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dipen on 3/24/2017.
 */
public class FibonacciModified2 {

   /* public static void main(String[] args) {
        *//* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. *//*
        Scanner sc = new Scanner(System.in);
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int n =  sc.nextInt();

        List<BigInteger> fib = new ArrayList();
        fib.add(t1);
        fib.add(t2);

        for(BigInteger i = BigInteger.valueOf(2); i <= n; i++)
        {
            fib.add(fib[i- BigInteger.valueOf(2)]+(Math.pow(fib[i-1],2)));
        }

        //NumberFormat formatter = new DecimalFormat("#0");
        //System.out.println(formatter.format(fib[n-1]));
        System.out.println(fib[n-1]);
        String.format("$%,.20f", fib[n-1]);
    }*/
}
