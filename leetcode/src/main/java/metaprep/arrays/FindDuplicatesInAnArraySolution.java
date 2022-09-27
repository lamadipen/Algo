package metaprep.arrays;
/**
 * https://www.metacareers.com/profile/coding_practice_question/?problem_id=377848313274668&c=840478233600155&ppid=208998290992738&practice_plan=0
 * https://algorithms.tutorialhorizon.com/find-duplicates-in-an-given-array-in-on-time-and-o1-extra-space/
 * */
public class FindDuplicatesInAnArraySolution {
    public static int[] findDuplicates(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[arr[i]%arr.length] = arr[arr[i]%arr.length] + arr.length;
        }

        int[] result = new int[arr.length];
        int index=0;
        for(int i=0; i < arr.length; i++){
            if(arr[i] >= arr.length*2){
                result[index] = i;
                index++;
            }
        }

        return result;
    }
}
