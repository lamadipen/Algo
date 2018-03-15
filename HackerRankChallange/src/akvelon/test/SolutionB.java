package akvelon.test;

/**
 * Created by dipen on 6/29/2017.
 */
public class SolutionB {

    private static int solution(int[] A) {
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1])
                result = result + 1;
        }
        int r = 0;
        for (int i = 1; i < n; i++) {
            int count = 0;
            if (i > 0) {
                if (A[i - 1] != A[i]  )
                    count = count + 1;
                else
                    count = count - 1;
            }
            if (i < n - 1) {
                if (A[i + 1] != A[i] || A[i - 1] != A[i] )
                    count = count + 1;
                else
                    count = count - 1;
            }
            r = Math.max(r, count);
        }
        return result + r;
    }

    public static void main(String [] args)
    {
        int [] A = {0,0,0,0,0,0,1};
        System.out.println(solution(A));

        int [] B = {1,0,0,0,0,0,0};
        System.out.println(solution(B));

        int [] C = {0,1,0};
        System.out.println(solution(C));


        int [] D = {0,0,0,0,0,0,1};
        System.out.println(solution(D));

        /**
         [1,0,0,0,0,0,0,]
         [1,1,1,1,1,1,1,1,1]
         [1,1,0]
         [0,1,0]
         [1,1,1,0]
         https://github.com/rvitale/exercises/blob/master/src/core/exercises/arrays/CoinFlip.java

         https://stackoverflow.com/questions/41945472/debug-the-given-code-for-coin-sequence


         * **/

    }
}
