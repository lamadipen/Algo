package kata.sortingandsearching;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GroupAnagramTest {

    @Test
    public void sortAnagramTest() {
        String[] arr = new String[5];
        arr[0] = "god";
        arr[1] = "top";
        arr[2] = "pot";
        arr[3] = "dog";
        arr[4] = "odg";

        GroupAnagram groupAnagram = new GroupAnagram();

        groupAnagram.sort(arr);
        System.err.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new String[]{"god", "dog", "odg", "top", "pot"}, arr);
    }

    @Test
    public void sorAnagramTest() {
        String[] arr = new String[5];
        arr[0] = "god";
        arr[1] = "top";
        arr[2] = "pot";
        arr[3] = "dog";
        arr[4] = "odg";

        GroupAnagram groupAnagram = new GroupAnagram();
        groupAnagram.groupAnagram(arr);
        System.err.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new String[]{"top", "pot", "god", "dog", "odg"}, arr);
    }
}