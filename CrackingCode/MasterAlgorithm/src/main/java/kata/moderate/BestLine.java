package kata.moderate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Moderate
 * Best Line
 * CC: pg 183 Q: 16.14
 * <p>
 * Not so important as you need to remember the slap calculation.
 * Solution Has a flaw.
 */
public class BestLine {
    Line findBestLine(GraphPoint[] points) {
        Map<Double, BLine> lineBySlope = getListOfLines(points);
        return getBestLine(lineBySlope);
    }

    private Map<Double, BLine> getListOfLines(GraphPoint[] points) {
        Map<Double, BLine> lineBySlope = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; i < points.length; i++) {
                BLine line = new BLine(points[i], points[j]);
                double key = BLine.floorToNearestEpsilon(line.slope);
                lineBySlope.put(key, line);
            }
        }
        return lineBySlope;
    }

    private Line getBestLine(Map<Double, BLine> lineBySlope) {
        BLine bestLine = null;
        int bestCount = 0;

        Set<Double> slopes = lineBySlope.keySet();

        for (double slope : slopes) {
            // ArrayList<BLine> lines = lineBySlope.get(slope);
        }
        return null;
    }
}

class GraphPoint {

}

class BLine {

    public double slope;

    public BLine(GraphPoint point, GraphPoint point1) {

    }

    public static double floorToNearestEpsilon(double slope) {
        return 0;
    }
}
