package interview;

/**
 * Created by dipen on 3/16/2017.
 */
class ChildClass extends SuperThisExample{

    public ChildClass()
    {
        super();

        System.out.println("IN child class");
    }

    public void test()
    {
        System.out.println("IN child test");
    }

    public static String staticTest()
    {
        System.out.println("In static Method");
        return "Return from static method";
    }

    public static void main(String [] args)
    {
        ChildClass cc = new ChildClass();
        cc.test();

        try{
            System.out.println("Try catch");
        }finally {
            System.out.println("Finally block");
        }

        System.out.println(staticTest());
        ChildClass cc1 = null;
        System.out.println(cc1.staticTest());
    }
}
