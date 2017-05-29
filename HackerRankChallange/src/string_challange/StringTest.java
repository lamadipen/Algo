package string_challange;

/**
 * Created by dipen on 3/28/2017.
 */
public class StringTest {

    public static void main(String [] args)
    {
        //stringTest1();

        StringTest st = new StringTest();
        //The above program will not compile with error as
        // “The method foo(String) is ambiguous for the type Test
        //st.foo(null);

        //stringTest2();
        stringTest3();


    }

    // It’s a simple yet tricky program, it will print “PANKAJ” because we are assigning s2
    // String to s1. Don’t get confused with == comparison operator.
    public static void stringTest1()
    {
        String s1 = "pankaj";
        String s2 = new String("PANKAJ");
        System.out.println(s1=s2);
    }

    public static void stringTest2()
    {
         /*
        It will print false because we are using new operator to create String,
        so it will be created in the heap memory and both s1, s2 will have different
        reference. If we create them using double quotes, then they will be part of
        string pool and it will print true.
         */
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2);

        String s3 = "abc";
        String s4 = "abc";
        System.out.println(s3 == s4);
    }

    public static void stringTest3() {

        /*
        It will print false because s2 is not of type String. If you will look at the equal’s
         method implementation in the String class, you will find a check using instanceof
         operator to check if the type of passed object is String? If not, then return false.
         */
        String s5 = "abc";
        StringBuffer s6 = new StringBuffer("abc");
        System.out.println(s5.equals(s6));
    }

    public void foo(String s)
    {
        System.out.println("String");
    }

    public void foo(StringBuffer sb)
    {
        System.out.println("String");
    }
}
