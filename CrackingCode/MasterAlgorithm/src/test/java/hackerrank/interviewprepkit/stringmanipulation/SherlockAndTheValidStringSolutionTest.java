package hackerrank.interviewprepkit.stringmanipulation;

import org.junit.Assert;
import org.junit.Test;

public class SherlockAndTheValidStringSolutionTest {

    @Test
    public void isValidTest() {
        SherlockAndTheValidStringSolution sherlockAndTheValidStringSolution = new SherlockAndTheValidStringSolution();
        Assert.assertEquals("YES", sherlockAndTheValidStringSolution.isValid("abc"));
        Assert.assertEquals("NO", sherlockAndTheValidStringSolution.isValid("aabbcd"));
        Assert.assertEquals("NO", sherlockAndTheValidStringSolution.isValid("aabbccddeefghi"));
        Assert.assertEquals("YES", sherlockAndTheValidStringSolution.isValid("abcdefghhgfedecba"));
    }
}