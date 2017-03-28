package algorithm.warmup;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by dipen on 3/24/2017.
 */
public class FibonacciModified {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int n = sc.nextInt();

        double [] fib = new double[n+1];
        fib[0] = t1;
        fib[1] = t2;

        for(int i = 2; i <= n; i++)
        {
            fib[i] = fib[i-2]+(Math.pow(fib[i-1],2));
        }
        NumberFormat formatter = new DecimalFormat("#0");
        System.out.println(formatter.format(fib[n]));
        System.out.println(fib[n]);


    }
}
