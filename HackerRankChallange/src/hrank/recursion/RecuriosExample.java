package hrank.recursion;

/**
 * Created by dipen on 2/22/2017.
 */
public class RecuriosExample {

    public static  void main(String[] args)
    {
        System.out.println(sumation(3));
        System.out.println(factorial(5));
    }
    //
    //4+3+2+1+0 =6
    public static int sumation(int n)
    {
        if(n <=0)
            return 0;
        else
            return n+sumation(n-1);

    }
    //4! = 4*3*2*1
    public static int factorial(int n)
    {
        if(n <=1)
            return 1;
        else
            return n*factorial(n-1);

    }
    //2^3
    public static int exponanation(int n,int p)
    {
        if(p <=0)
            return 1;
        else
            return n*exponanation(n,p-1);

    }
}
