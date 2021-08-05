package hackerrank.interviewprepkit.stringmanipulation;

import org.junit.Assert;
import org.junit.Test;

public class CommonChildTest {

    @Test
    public void commonChildTest1() {
        int actual = CommonChild.longestCommonChild("HARRY", "SALLY");
        Assert.assertEquals(2, actual);
    }

    @Test
    public void commonChildTest2() {
        int actual = CommonChild.longestCommonChild("SHINCHAN", "NOHARAAA");
        Assert.assertEquals(3, actual);
    }

    @Test
    public void commonChildCacheTest1() {
        int actual = CommonChild.longestCommonChildWithCache("HARRY", "SALLY");
        Assert.assertEquals(2, actual);
    }

    @Test
    public void commonChildCacheTest2() {
        int actual = CommonChild.longestCommonChildWithCache("SHINCHAN", "NOHARAAA");
        Assert.assertEquals(3, actual);
    }

    @Test
    public void commonChildBottomUpApproach1() {
        int actual = CommonChild.commonChildBottomUpApproach("SHINCHAN", "NOHARAAA");
        Assert.assertEquals(3, actual);
    }

    @Test
    public void commonChildBottomUpApproachImprovedSpace1() {
        int actual = CommonChild.commonChildBottomUpApproachImprovedSpace("SHINCHAN", "NOHARAAA");
        Assert.assertEquals(3, actual);
    }
}