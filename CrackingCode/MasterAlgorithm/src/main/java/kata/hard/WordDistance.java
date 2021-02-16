package kata.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hard
 * Word Distance
 * CC: pg 187 Q: 17.11
 */
public class WordDistance {

    /**
     * Runtime O(n)
     *
     * @param words
     * @param w1
     * @param w2
     * @return
     */
    public LocationPoint findClosest(String[] words, String w1, String w2) {
        LocationPoint best = new LocationPoint(-1, -1);
        LocationPoint current = new LocationPoint(-1, -1);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(w1)) {
                current.point1 = i;
                best.updateMin(current);
            } else if (word.equals(w2)) {
                current.point2 = i;
                best.updateMin(current);
            }
        }
        return best;
    }

    Map<String, List<Integer>> locations = new HashMap<>();

    /**
     * Runtime O(A +B) After Populating the HashMap
     * Where A is size of list of w1 and B is sized of list of w2
     *
     * @param w1
     * @param w2
     * @return
     */
    public LocationPoint findClosestOptimized(String w1, String w2) {
        List<Integer> loctions1 = locations.get(w1);
        List<Integer> loctions2 = locations.get(w2);

        return findMinDistance(loctions1, loctions2);
    }

    private LocationPoint findMinDistance(List<Integer> loctions1, List<Integer> loctions2) {
        if (loctions1 == null
                || loctions2 == null
                || loctions1.size() == 0
                || loctions2.size() == 0) {
            return null;
        }
        int index1 = 0;
        int index2 = 0;
        LocationPoint best = new LocationPoint(loctions1.get(index1), loctions2.get(index2));
        LocationPoint current = new LocationPoint(loctions1.get(index1), loctions2.get(index2));

        while (index1 < loctions1.size() && index2 < loctions2.size()) {
            current.setPoints(loctions1.get(index1), loctions2.get(index2));
            best.updateMin(current);

            if (loctions1.get(index1) < loctions2.get(index2)) {
                index1++;
            } else {
                index2++;
            }
        }
        return best;
    }


    /**
     * Runtime O(n) to populate the HashMap
     *
     * @param words
     */
    public void populateLocationPairs(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (locations.containsKey(word)) {
                List<Integer> locs = locations.get(word);
                locs.add(i);
            } else {
                ArrayList<Integer> locs = new ArrayList<>();
                locs.add(i);
                locations.put(word, locs);
            }
        }
    }
}

class LocationPoint {
    int point1;
    int point2;

    public LocationPoint(int point1, int point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public int distance() {
        return Math.abs(point1 - point2);
    }

    public void updateMin(LocationPoint locationPoint) {
        if (!valid() || distance() > locationPoint.distance()) {
            this.point1 = locationPoint.point1;
            this.point2 = locationPoint.point2;
        }
    }

    private boolean valid() {
        return point1 >= 0 && point2 >= 0;
    }

    public void setPoints(int p1, int p2) {
        this.point1 = p1;
        this.point2 = p2;
    }
}
