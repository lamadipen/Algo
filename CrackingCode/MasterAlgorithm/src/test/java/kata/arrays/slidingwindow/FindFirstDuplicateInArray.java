package kata.arrays.slidingwindow;

import org.junit.Test;

public class FindFirstDuplicateInArray {

    @Test
    public void findFirstDuplicate() {
        //Note
        //1 to Array.size -1
        int[] input = {2, 1, 3, 5, 3, 2};
//        int[] input = {1,2,1,2,3,3};
//        int[] input = {2,2,1,2,3,3};
        int fixedPointer = 1;
        for (int i = 0; i < input.length; i++) {
            int index = Math.abs(input[i]) - fixedPointer;

            if (input[index] < 0) {
                System.out.println("value " + Math.abs(input[index]));
                return;
            } else {
                input[index] = -input[index];
            }
        }
    }

//    @Test
//    public void findLastDuplicate() {
//        //Note
//        //1 to Array.size -1
////        int[] input = {2, 1, 3, 5, 3, 2};
////        int[] input = {1,2,1,2,3,2};
//        int[] input = {2,2,1,2,3,1};
//        int fixedPointer = 5;
//        for (int i = 0; i < input.length; i++) {
//            int index = fixedPointer - Math.abs(input[i]);
//
//            if (input[index] < 0) {
//                System.out.println("value " + Math.abs(input[index]));
//                return;
//            } else {
//                input[index] = -input[index];
//            }
//        }
//    }
}
