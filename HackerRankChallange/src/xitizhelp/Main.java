package xitizhelp;

import java.util.Collection;
import java.util.Set;

/**
 * Created by dipen on 7/21/2017.
 */
public class Main {

    public static void main(String  args[])
    {

    }

    class MyClass implements test{

        @Override
        public Set<String> test() {
            return null;
        }
    }
}

interface test{
    Collection<String> test();
}
