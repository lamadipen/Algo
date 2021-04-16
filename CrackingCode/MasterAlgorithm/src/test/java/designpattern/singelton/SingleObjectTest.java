package designpattern.singelton;

import org.junit.Test;

public class SingleObjectTest {

    @Test
    public void onlyOneInstance() {
        SingleObject instance = SingleObject.getInstance();
        System.out.println(instance.data);

        SingleObject instance2 = SingleObject.getInstance();
        System.out.println(instance.data);
    }

}