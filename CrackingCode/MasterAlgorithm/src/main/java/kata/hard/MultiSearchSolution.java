package kata.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hard
 * Multi Search
 * CC: pg 189 Q: 17.17
 */
public class MultiSearchSolution {

    /**
     * Runtime O(sbk)
     * where s - length of items in smalls array
     * b - length of big string
     * k - length of longest string in smalls array
     *
     * @param big
     * @param smalls
     * @return
     */
    public Map<String, List<Integer>> search(String big, String[] smalls) {
        Map<String, List<Integer>> lookUp = new HashMap<>();

        for (String small : smalls) {
            List<Integer> locations = search(big, small);
            lookUp.put(small, locations);
        }
        return lookUp;
    }

    /**
     * Better the searchWithSubStingAndEquals
     *
     * @param big
     * @param small
     * @return
     */
    public List<Integer> search(String big, String small) {
        List<Integer> locations = new ArrayList();

        for (int i = 0; i < big.length() - small.length() + 1; i++) {
            if (isSubstringAtIndex(big, small, i)) {
                locations.add(i);
            }
        }
        return locations;
    }

    /**
     * Alternative of search function but search function is slightly better than this
     *
     * @param big
     * @param small
     * @return
     */
    public List<Integer> searchWithSubStingAndEquals(String big, String small) {
        List<Integer> locations = new ArrayList();

        for (int i = 0; i < big.length() - small.length() + 1; i++) {
            if (big.substring(i).equals(small)) {
                locations.add(i);
            }
        }
        return locations;
    }

    private boolean isSubstringAtIndex(String big, String small, int offset) {
        for (int i = 0; i < small.length(); i++) {
            if (big.charAt(offset + i) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Runtime O(b^2 + kt)
     *
     * @param big
     * @param smalls
     * @return
     */
    public Map<String, List<Integer>> searchWithTries(String big, String[] smalls) {
        Map<String, List<Integer>> lookUp = new HashMap<>();

        Tries tries = new Tries();
        for (int i = 0; i < big.length(); i++) {
            String suffix = big.substring(i);
            tries.addString(suffix, i);
        }

        for (String small : smalls) {
            List<Integer> locations = tries.search(small);
            subractValue(locations, small.length());
            lookUp.put(small, locations);
        }

        return lookUp;
    }

    private void subractValue(List<Integer> locations, int delta) {
        if (locations == null) {
            return;
        }
        for (int i = 0; i < locations.size(); i++) {
            locations.set(i, locations.get(i) - delta);
        }
    }

    /**
     * Run time O(kt +bt)
     * where K is length of longest string
     * b is length of big string
     * t is length of small string array
     *
     * @param big
     * @param smalls
     * @return
     */
    public Map<String, List<Integer>> searchWithTriesOptimized(String big, String[] smalls) {
        Map<String, List<Integer>> lookUp = new HashMap<>();

        int maxLen = big.length();
        TriesNode root = createTriesFromString(smalls, maxLen).root;

        for (int i = 0; i < big.length(); i++) {
            List<String> strings = findStringAtLoc(root, big, i);
            insertIntoHashmap(strings, lookUp, i);
        }
        return lookUp;
    }

    private void insertIntoHashmap(List<String> strings, Map<String, List<Integer>> lookUp, int index) {
        for (String s :
                strings) {
            List<Integer> locations;
            if (lookUp.containsKey(s)) {
                locations = lookUp.get(s);
            } else {
                locations = new ArrayList<>();
            }
            locations.add(index);
            lookUp.put(s, locations);
        }
    }

    private List<String> findStringAtLoc(TriesNode root, String big, int start) {
        ArrayList<String> strings = new ArrayList<>();
        int index = start;

        while (index < big.length()) {
            root = root.children.get(big.charAt(index));
            if (root == null) {
                break;
            }
            if (root.terminates()) { // is complete string and terminates at
                strings.add(big.substring(start, index + 1));
            }
            index++;
        }
        return strings;
    }

    private Tries createTriesFromString(String[] smalls, int maxLen) {
        Tries tries = new Tries();
        for (String small : smalls) {
            if (small.length() <= maxLen) {
                tries.addString(small, 0);
            }
        }
        return tries;
    }
}

class Tries {
    TriesNode root = new TriesNode();

    public Tries() {
    }

    public void addString(String s, int index) {
        root.insertString(s, index);
    }

    public List<Integer> search(String s) {
        return root.search(s);
    }
}

class TriesNode {
    Map<Character, TriesNode> children;
    List<Integer> indexes;

    public TriesNode() {
        this.children = new HashMap<>();
        this.indexes = new ArrayList<>();
    }

    public void insertString(String word, int index) {
        if (word == null) {
            return;
        }
        indexes.add(index);
        if (word.length() > 0) {
            char first = word.charAt(0);
            TriesNode child = null;
            if (children.containsKey(first)) {
                child = children.get(first);
            } else {
                child = new TriesNode();
                children.put(first, child);
            }
            String remaining = word.substring(1);
            child.insertString(remaining, index + 1);
        } else {
            children.put('\0', null);
        }
    }

    public List<Integer> search(String s) {
        if (s == null || s.length() == 0) {
            return indexes;
        }
        if (s.length() > 0) {
            char first = s.charAt(0);
            if (children.containsKey(first)) {
                String remaining = s.substring(1);
                return children.get(first).search(remaining);
            }
        }
        return null;
    }

    public boolean terminates() {
        return children.containsKey('\0');
    }
}
