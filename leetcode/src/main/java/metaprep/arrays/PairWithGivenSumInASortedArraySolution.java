package metaprep.arrays;
/**
 * https://www.metacareers.com/profile/coding_practice_question/?problem_id=377848313274668&c=840478233600155&ppid=208998290992738&practice_plan=0
 *
 * */
public class PairWithGivenSumInASortedArraySolution {
    public static int countPairs(int[] arr, int k) {
        int left = 0;
        int right =arr.length -1;
        int pairCount = 0;

        while (left < right) {
            int delta = k - arr[left];
            if(delta == arr[right]){
                pairCount++;
                left++;
                right--;
            }else if(delta < arr[right]){
                right--;
            }else {
                left++;
            }
        }
        return pairCount;
    }
}
