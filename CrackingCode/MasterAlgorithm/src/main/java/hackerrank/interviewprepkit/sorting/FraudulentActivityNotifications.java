package hackerrank.interviewprepkit.sorting;

import java.util.List;

/**
 * Interview Preparation Kit | Sorting |Fraudulent Activity Notifications
 * Fraudulent Activity Notifications
 */
public class FraudulentActivityNotifications {
    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        int notificationCount = 0;

        int[] data = new int[201];

        for (int i = 0; i < d; i++) {
            data[expenditure.get(i)]++;
        }

        for (int i = d; i < expenditure.size(); i++) {
            double median = getMedian(d, data);

            if (expenditure.get(i) >= median * 2) {
                notificationCount++;
            }

            data[expenditure.get(i)]++;
            data[expenditure.get(i - d)]--;
        }


        return notificationCount;
    }

    private static double getMedian(int d, int[] data) {
        double median = 0;
        if (d % 2 == 0) {
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for (int i = 0; i < data.length; i++) {
                count += data[i];
                if (m1 == null && count >= d / 2) {
                    m1 = i;
                }
                if (m2 == null && count >= d / 2 + 1) {
                    m2 = i;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        } else {
            int count = 0;
            for (int i = 0; i < data.length; i++) {
                count += data[i];
                if (count > d / 2) {
                    median = i;
                    break;
                }
            }
        }
        return median;
    }


}
