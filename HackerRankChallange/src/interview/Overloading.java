package interview;
/**
 * Created by dipen on 3/15/2017.
 */
public class Overloading {

    int	y=20;
    //overloaded example
    String sum(int a,int b){System.out.println(a+b);return "Dipen";}
    int sum(int a,int b,int c){System.out.println(a+b+c); return 1;}

    //overloaded method
    public static void main(int args[]){
        Overloading cal = new Overloading();
        cal.sum(20,30,60);
        cal.sum(20,20);

    }

    //Example of call-by-value
    public void callByValue(int x)
    {
        x=100;
    }

    //Example of call-by-reference
    public void callByReference(Overloading t)
    {
        t.y=50;
    }

    //Final modifier test
    String name= new String("Dipen");


    public static void main(String args[]){
        Overloading cal = new Overloading();
        cal.sum(20,30,60);
        cal.sum(20,20);

        int x =50;
        cal.callByValue(x);
        System.out.println(x);
        System.out.println();

        System.out.println(cal.y);
        cal.callByReference(cal);
        System.out.println(cal.y);

        //final modifier test
        System.out.println(cal.name);
        cal.name="Ram";
        System.out.println(cal.name);

        StaticExample.test();
    }
}
