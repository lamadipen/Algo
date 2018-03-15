package hrank.SparseArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dipen on 3/2/2018.
 */
public class Sloution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> strList = new ArrayList<String>();

        for(int i =0; i < n; i++){
            strList.add(sc.next());
        }
        int q = sc.nextInt();

        for(int i=0; i < q; i++){
            String searchStr = sc.next();
            int matchCount = 0;
            for (String item: strList) {
                if(searchStr.equals(item)){
                    matchCount++;
                }
            }
            System.out.println(matchCount);
        }
    }
}
