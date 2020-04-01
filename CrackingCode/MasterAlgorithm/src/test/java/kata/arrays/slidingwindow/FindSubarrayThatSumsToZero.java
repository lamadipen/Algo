package kata.arrays.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given array of integer, find subarray that sums to zero
 * Input: [2,4,-2,1,-3,5,-3]
 * Output: [4,-2,1,3]
 */
public class FindSubarrayThatSumsToZero {
    @Test
    public void findSubarrayThatSumsToZero() {
        int[] input = {2, 4, -2, 1, -3, 5, -3};
        int[] expected = {4, -2, 1, 3};
        Map<Integer, Integer> map = new HashMap<>();

        int pointer1 = 0;
        int pointer2 = 0;
        //case one if the element it self is zero
        //case two if the sum from 0 to i th element is zero
        //case three if the sum is already present in the array/ Hash map
        for (int i = 0; i < input.length - 1; i++) {
            int sum = input[i] + input[i + 1];

            if (input[i] == 0) {
                pointer2 = i;
                break;
            }
            if (sum == 0) {
                pointer2 = i;
                break;
            }
            if (map.containsKey(sum)) {
                pointer1 = map.get(sum);
                pointer2 = i;
                break;
            }else{
                map.put(sum, i);
            }

        }

        int[] tempArray = new int[(pointer2 - pointer1) + 1];
        int pointer3 = 0;
        for (int i = pointer1; i <= tempArray.length; i++) {
            tempArray[pointer3++] = input[i];
        }

        System.out.println(tempArray);

        Assert.assertArrayEquals(expected, tempArray);

    }
}
