package hrank.TenDaysofStatistics;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * Created by dipen on 3/17/2017.
 */
public class Day0SolutionMeanMedianMode {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalSum = 0;
        int[] arr= new int[n];
        Map<Integer,Integer> range = new HashMap<Integer,Integer>();
        for(int i=0; i< n; i++)
        {
            int element = sc.nextInt();
            totalSum = element+totalSum;
            arr[i] =element;

            if(range.containsKey(element))
            {
                int count = range.get(element);
                range.put(element,1+count);
            }
            else
            {
                range.put(element,1);
            }
        }
        Arrays.sort(arr);
        //System.out.println(totalSum +" "+n);
        double mean = totalSum/n;
        double meadin =0;
        int mode=0;
        if(n%2==0)
        {
            int mid = n/2;
            meadin = (double)(arr[mid] + arr[mid-1])/2;
        }else
        {
            int mid = n/2;
            meadin = arr[mid];
        }

        int modeChecker =0;
        for(int mElement:range.keySet())
        {

            if(range.get(mElement) > modeChecker)
            {
                mode =mElement;
                modeChecker =range.get(mElement);
            }
            if(range.get(mElement) == modeChecker && mode > mElement)
            {
                mode =mElement;
            }

        }

        System.out.println(mean);
        System.out.println(meadin);
        System.out.println(mode);

    }

}


