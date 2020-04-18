package kata.arrays.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class FindMostFrequentInAnArray {

    @Test
    public void findMostFrequentInArrayTest() {
        int[] input = {3, 1, 1, 3, 2, 3, 1, 1};

        int actual = findMostFrequentInArray(input);

        Assert.assertEquals(1, actual);
    }


    public int findMostFrequentInArray(int[] input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max =-1;
        int item = -1;
        for (int i = 0; i < input.length; i++) {
            int key = input[i];
            if (map.containsKey(key)) {
                Integer sum = map.get(key) +1 ;
                map.put(key, sum);
                System.err.println(key +" : "+ sum);
            }else {
                map.put(key, 1);
            }
            if (max < map.get(key)) {
                max = map.get(key);
                item = key;
            }
        }

        return  item ;
    }

}
