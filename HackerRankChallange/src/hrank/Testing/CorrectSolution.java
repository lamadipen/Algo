package hrank.Testing;

/**
 * Created by dipen on 3/16/2017.
 */
public class CorrectSolution {
    public static void main(String [] args)
    {
        System.out.println( 5 );
        String s = "-1 1";
        for ( int i=3; i<=7 ; i++)
            System.out.printf( "%d %d\n%s\n", i, i%2==0?1:i, s +=" 0"  );
    }
}
