package hackerrank.interviewprepkit.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

public class BalancedBracketsTest {
    @Test
    public void test1() {
        String result1 = BalancedBrackets.isBalanced("()}");
        Assert.assertEquals("NO", result1);

        String result2 = BalancedBrackets.isBalanced("(})");
        Assert.assertEquals("NO", result2);

        String result3 = BalancedBrackets.isBalanced("(()");
        Assert.assertEquals("NO", result3);
    }

    @Test
    public void test2() {
        String result1 = BalancedBrackets.isBalanced("()");
        Assert.assertEquals("YES", result1);

        String result2 = BalancedBrackets.isBalanced("{[()]}");
        Assert.assertEquals("YES", result2);

        String result3 = BalancedBrackets.isBalanced("{[(])}");
        Assert.assertEquals("NO", result3);

        String result4 = BalancedBrackets.isBalanced("{{[[(())]]}}");
        Assert.assertEquals("YES", result4);

        String result5 = BalancedBrackets.isBalanced("{(([])[])[]}");
        Assert.assertEquals("YES", result5);

        String result6 = BalancedBrackets.isBalanced("{(([])[])[]]}");
        Assert.assertEquals("NO", result6);

        String result7 = BalancedBrackets.isBalanced("{(([])[])[]}[]");
        Assert.assertEquals("YES", result7);
    }

    @Test
    public void test3() {
        String result1 = BalancedBrackets.isBalancedBool("()");
        Assert.assertEquals("YES", result1);

        String result2 = BalancedBrackets.isBalancedBool("{[()]}");
        Assert.assertEquals("YES", result2);

        String result3 = BalancedBrackets.isBalancedBool("{[(])}");
        Assert.assertEquals("NO", result3);

        String result4 = BalancedBrackets.isBalancedBool("{{[[(())]]}}");
        Assert.assertEquals("YES", result4);

        String result5 = BalancedBrackets.isBalancedBool("{(([])[])[]}");
        Assert.assertEquals("YES", result5);

        String result6 = BalancedBrackets.isBalancedBool("{(([])[])[]]}");
        Assert.assertEquals("NO", result6);

        String result7 = BalancedBrackets.isBalancedBool("{(([])[])[]}[]");
        Assert.assertEquals("YES", result7);
    }

}