package hackerrank.interviewprepkit.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FraudulentActivityNotificationsTest {

    @Test
    public void activityNotificationsTest1() {
        List<Integer> expenditureList = Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5);
        int result = FraudulentActivityNotifications.activityNotifications(expenditureList, 5);

        Assert.assertEquals(2, result);
    }

    @Test
    public void activityNotificationsTest2() {
        List<Integer> expenditureList = Arrays.asList(1, 2, 3, 4, 4);
        int result = FraudulentActivityNotifications.activityNotifications(expenditureList, 4);

        Assert.assertEquals(0, result);
    }

}