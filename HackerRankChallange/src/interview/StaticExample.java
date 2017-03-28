package interview;

/**
 * Created by dipen on 3/15/2017.
 */
public class StaticExample {
    public static int i=1;

    public static void test()
    {
        System.out.println("Static method");
    }

    public static int test(int j)
    {
        System.out.println("Static method with parameter" +j);
        return j;
    }

    public static  void main(String [] args)
    {
        test();
        test(90);
        System.out.println("Static variable"+i);
        i=20;
        System.out.println("Static variable"+i);
    }
}
