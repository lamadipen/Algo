package hrank.RansomNoteHashTable;

import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public Solution(String magazine, String note) {
        magazineMap = new HashMap();
        noteMap = new HashMap();

        fillMap(magazine,magazineMap);
        fillMap(note,noteMap);

    }

    public void fillMap(String value, Map<String, Integer> map)
    {
        if(value == null)
            return;
        String [] strArray = value.split(" ");

        for(String word: strArray)
        {
            if(map.containsKey(word))
            {
                int val = map.get(word);
                map.put(word,val+1);
            }
            else
            {
                map.put(word,1);
            }

        }
    }

    public boolean solve() {

        for(String key : noteMap.keySet())
        {
            if(!magazineMap.containsKey(key))
            {
                return false;
            }

            // Now make sure there are enough words on magazine for a given word
            Integer magazineCount = magazineMap.get(key);
            Integer noteCount = noteMap.get(key);

            if (magazineCount < noteCount) return false;

        }


        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}