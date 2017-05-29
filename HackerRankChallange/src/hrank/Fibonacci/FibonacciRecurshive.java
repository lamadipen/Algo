package hrank.Fibonacci;

/**
 * Created by dipen on 3/16/2017.
 */
public class FibonacciRecurshive {
    static int fib(int n)
    {
        //System.out.println(n);
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }

    static int fib1(int n)
    {

        if (n <= 2) return 1;
        else return fib(n-1) + fib(n-2);
    }
    public static void main (String args[])
    {
        int n = 9;
        System.out.println(fib(n));
    }
}
