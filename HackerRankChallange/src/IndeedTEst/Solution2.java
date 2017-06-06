package IndeedTEst;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by dipen on 6/1/2017.
 */
public class Solution2 {


    /*
 * Complete the function below.
 */

    static int[] getMinimumUniqueSum(String[] arr) {
        int[] sqarr = new int[arr.length];

        for(int k= 0; k < arr.length; k++)
        {
            String [] data = arr[k].split(" ");

            int start = Integer.parseInt(data[0]);
            int end =Integer.parseInt(data[1]);

            int count =0;
            for(int i = start; i <= end; i++)
            {
                for(int j =1; j*j<=i;j++)
                {
                    if(j*j==i)
                    {
                        count++;
                    }
                }

                System.out.println(count);
            }

            sqarr[k] = count;

        }

        return sqarr;
    }




    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        String[] _arr = new String[_arr_size];
        String _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            try {
                _arr_item = in.nextLine();
            } catch (Exception e) {
                _arr_item = null;
            }
            _arr[_arr_i] = _arr_item;
        }

        res = getMinimumUniqueSum(_arr);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

}
