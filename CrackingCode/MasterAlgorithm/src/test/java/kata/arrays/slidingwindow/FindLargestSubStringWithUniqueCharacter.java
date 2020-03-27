package kata.arrays.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the largest substring with unique characters
 * Input: whatwhywhere
 * Result: atwhy
 *
 * */
public class FindLargestSubStringWithUniqueCharacter {
    @Test
    public void findLargestSubStringWithUniqueCharacter() {
        //This needs set to track all dupliate values see the solution below
        String input = "whatwhywhere";
        String expected = "atwhy";
        int pointer1 =  0;
        int pointer2 = 1;
        String largestSubstring = "";

        for (int i = pointer2; pointer2 < input.length(); pointer2++) {
            if (input.charAt(pointer1) == input.charAt(pointer2)) {
                if(largestSubstring.length() < (pointer2 -pointer1)){
                    largestSubstring = input.substring(pointer1, pointer2);
                }
                pointer1++;
                pointer2 = pointer1 + 1;
            }else{
                largestSubstring = input.substring(pointer1, pointer2);
            }
        }

        Assert.assertEquals(expected, largestSubstring);

    }

    @Test
    public void findLargestSubStringWithUniqueCharacterWithSet() {
        String input = "whatwhywhere";
        String expected = "atwhy";
        int pointer =  0;
        String largestSubstring = "";
        Set<Character> watcher = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char item = input.charAt(i);
            if (watcher.contains(item)) {
                String tempSubString = input.substring(pointer, i);
                if(tempSubString.length() > largestSubstring.length()){
                    largestSubstring = tempSubString;
                }
                watcher.clear();
                pointer++;
                i=pointer-1;
            }else{
                watcher.add(item);
            }
        }

        Assert.assertEquals(expected, largestSubstring);

    }
}
