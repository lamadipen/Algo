package kata.systemdesign.socialnetwork;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class FindFriendsTest {

    @Test
    public void findFriendsWithNoConnectionTest() {
        FindFriends findFriends = new FindFriends();

        HashMap<Integer, Person> people = new HashMap<>();

        for (int i = 1; i < 10; i++) {
            Person person = new Person();
            person.id = i;
            person.name = "name_" + i;
            person.friends = Collections.emptyList();
            people.put(i, person);
        }


        LinkedList<Person> pathBiBFS = findFriends.findPathBiBFS(people, 1, 9);

        Assert.assertNull(pathBiBFS);
    }

    @Test
    public void findFriendsWithDirectConnectionTest() {
        FindFriends findFriends = new FindFriends();
        HashMap<Integer, Person> people = new HashMap<>();

        for (int i = 1; i < 10; i++) {
            Person person = new Person();
            person.id = i;
            person.name = "name_" + i;
            if (i == 1) {
                ArrayList<Integer> friends = new ArrayList<>();
                friends.add(2);
                friends.add(5);
                person.friends = friends;
            } else if (i == 9) {
                ArrayList<Integer> friends = new ArrayList<>();
                friends.add(7);
                friends.add(6);
                friends.add(5);
                person.friends = friends;
            } else {
                person.friends = Collections.emptyList();
            }
            people.put(i, person);
        }

        LinkedList<Person> pathBiBFS = findFriends.findPathBiBFS(people, 1, 9);
        Assert.assertNotNull(pathBiBFS);
    }

    @Test
    public void findFriendsWithIndirectConnectionTest() {
        FindFriends findFriends = new FindFriends();
        HashMap<Integer, Person> people = new HashMap<>();

        for (int i = 1; i < 10; i++) {
            Person person = new Person();
            person.id = i;
            person.name = "name_" + i;
            if (i == 1) {
                ArrayList<Integer> friends = new ArrayList<>();
                friends.add(2);
                friends.add(5);
                person.friends = friends;
            } else if (i == 6) {
                ArrayList<Integer> friends = new ArrayList<>();
                friends.add(5);
                person.friends = friends;
            } else if (i == 9) {
                ArrayList<Integer> friends = new ArrayList<>();
                friends.add(7);
                friends.add(6);
                person.friends = friends;
            } else {
                person.friends = Collections.emptyList();
            }
            people.put(i, person);
        }

        LinkedList<Person> pathBiBFS = findFriends.findPathBiBFS(people, 1, 9);
        Assert.assertNotNull(pathBiBFS);
    }

}