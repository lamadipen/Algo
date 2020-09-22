package kata.sortingandsearching;

import java.util.*;

public class GroupAnagram {
    public void sort(String[] arr) {
        Arrays.sort(arr, new MyComparator());
    }

    public void groupAnagram(String[] arr) {
        HashMap<String, List<String>> map = new HashMap();

        for (String word : arr) {
            String key = sortString(word);
            List<String> words;

            if (map.containsKey(key)) {
                words = map.get(key);
                words.add(word);
                map.put(key, words);
            } else {
                words = new ArrayList<>();
                words.add(word);
                map.putIfAbsent(key, words);
            }
        }
        int index = 0;
        for (String key : map.keySet()) {
            List<String> words = map.get(key);
            for (String word : words) {
                arr[index] = word;
                index++;
            }
        }
    }

    private String sortString(String s1) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return (sortString(s1)).compareTo(sortString(s2));
    }

    private String sortString(String s1) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

