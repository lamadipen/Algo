package hrank.databaseExample;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dipen on 3/12/2017.
 */
public class User {
    String username;
    String password;
    int age;
    Set<Integer> orderId;

    public User(String uname, String pass, int ag, Set oid)
    {
        this.username = uname;
        this.password = pass;
        this.age = ag;
        this.orderId =oid;
    }

    public static void main(String [] args){
        Set a= new HashSet();
        a.add(1);

        User user = new User("dipen","lama",20,a);
    }
}
