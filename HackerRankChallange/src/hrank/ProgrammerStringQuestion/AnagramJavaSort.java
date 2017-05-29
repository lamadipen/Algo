package hrank.ProgrammerStringQuestion;

import java.util.*;

/**
 * Created by dipen on 5/18/2017.
 */
public class AnagramJavaSort {
    static boolean isAnagram(String first, String second)
    {





        return true;
    }

    public static void main(String [] args)
    {
        /*//System.out.println(isAnagram("Mother In Law", "Hitler Woman"));
        System.out.println( isAnagram("keEp", "peeK"));
        //System.out.println(isAnagram("SiLeNt CAT", "LisTen AcT"));
        System.out.println( isAnagram("Debit Card", "Bad Credit"));
        System.out.println( isAnagram("DORMITORY", "Dirty Room"));
        System.out.println( isAnagram("School MASTER", "The ClassROOM"));
        System.out.println(  isAnagram("Toss", "Shot"));
        System.out.println(    isAnagram("joy", "enjoy"));
        System.out.println(  isAnagram("ASTRONOMERS", "NO MORE STARS"));
*/
        int a = 1 << 2;

       // System.out.println(a);
      //  System.out.println(b);
       // System.out.println(c);

       /*   final char SEPARATOR = 0x20;
          final int MESSAGE_TYPE = 1;
        System.out.println(SEPARATOR + MESSAGE_TYPE + "=A");

*/

 /*       for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
if (b == 0x90) {
 System.out.print("We found it");
}
}*/


       /* Map<Integer, String> hashMap = new HashMap<Integer, String>(5);
        hashMap.put(1, "apple");
        hashMap.put(2, null);
        hashMap.put(new Integer(3), "peach");
        hashMap.put(3, "orange");
        hashMap.put(4, "peach");

        for (String v : hashMap.values()) {
            if ("orange".equals(v)) {
                hashMap.put(5, "banana");
            }
        }
        System.out.println(hashMap.get(5));*/

        final List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 5, 2, 3, 7, 3, 8, 9);
        final Integer pos = Integer.valueOf(3);
        list.remove(pos);
        System.out.println(list);



    }

}


