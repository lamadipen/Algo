package hrank.runTime;

import java.util.HashMap;

/**
 * Created by dipen on 3/10/2017.
 */
public class RuntimePractice {

    public static int findNumOfRepetition(String s, char c)
    {
        int sum =0;
        for (int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==c)
            {sum++;}
        }

        return sum;
    }

    public static int[] findNumofRepetitionsV1(String s,char[] c)
    {
        int[] sums = new int[c.length];
        for(int i=0; i<s.length();i++)
        {
            for(int j=0;j <c.length;j++)
            {
                    if(s.charAt(i)==c[j])
                    {
                        sums[j] = sums[j]+1;
                    }

            }
        }
        return sums;
    }

    public static int[] findNumofRepetitionsV2(String s,char[] c)
    {
        int[] sums = new int[c.length];
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++)
        {
            if(!map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i),1);
            }
            else
            {
                int sum = map.get(s.charAt(i));
                map.put(s.charAt(i),sum+1);
            }
        }

        for(int j=0;j<c.length;j++)
        {
            int sum;
            if(!map.containsKey(c[j]))
            {
                sums[j] =0;
            }else
            {
                sums[j]=map.get(c[j]);
            }
        }
        return sums;
    }


    public static void main(String[] args)
    {
        char[]  chars= {'c','a','b','s','d'};
        String st = "abcaabacababababsdfsdfsdfababadfasdfasdfsdfsdfsfqweqwdfggavbababababababasdadsgfdgdasadfsdafsdfsafbvcvbcvcbcxvbxcbcx";
        long startTime = System.currentTimeMillis();
        findNumOfRepetition(st,'c');
        long endTime = System.currentTimeMillis();
        long duration = endTime-startTime;
        System.out.println("Test 1"+ duration+" ms");


        startTime = System.currentTimeMillis();
        findNumofRepetitionsV1(st,chars);
        endTime = System.currentTimeMillis();

        duration = endTime-startTime;
        System.out.println("Test 2"+ duration+" ms");


         startTime = System.currentTimeMillis();
         findNumofRepetitionsV2(st,chars);
         endTime = System.currentTimeMillis();

        duration = endTime-startTime;
        System.out.println("Test 3"+ duration +" ms");
    }
}
