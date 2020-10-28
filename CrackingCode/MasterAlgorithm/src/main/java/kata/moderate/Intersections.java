package kata.moderate;

/**
 * Moderate
 * Intersections
 * CC: pg 181 Q: 16.3
 */
public class Intersections {

    public Point findIntersection(Point start1, Point end1, Point start2, Point end2) {
        if (start1.x > end1.x) {
            swap(start1, end1);
        }
        if (start2.x > end2.x) {
            swap(start2, end2);
        }
        if (start1.x > start2.x) {
            swap(start1, start2);
            swap(end1, end2);
        }

        //compute Line (slope and y-intercept)
        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        //if lines are parallel they intercept only if the have same y-intercept
        if (line1.slope == line2.slope) {
            if (line1.yIntercept == line2.yIntercept && isBetween(start1, start2, end1)) {
                return start2;
            }
            return null;
        }
        /**Get intersecting coordinate see linear equation and how calculate intersecting point
         * of two straight line in math
         * */
        double intersectX = (line2.yIntercept - line1.yIntercept) / (line1.slope - line2.slope);
        double intersectY = intersectX * line1.slope + line1.yIntercept;

        Point intersectPoint = new Point(intersectX, intersectY);

        /** check if within line segment range. */
        if (isBetween(start1, intersectPoint, end1) && isBetween(start2, intersectPoint, end2)) {
            return intersectPoint;
        }
        return null;
    }

    /**
     * Check if middle is between start and end
     */
    private boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
    }

    /**
     * Check if middle is between start and end
     */
    private boolean isBetween(double start, double middle, double end) {
        if (start > end) {
            return end <= middle && middle <= start;
        } else {
            return start <= middle && middle <= end;
        }
    }

    private void swap(Point one, Point two) {
        double tempX = one.x;
        double tempY = one.y;
        one.setLocation(two.x, two.y);
        two.setLocation(tempX, tempY);
    }

}

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Line {
    double slope;
    double yIntercept;

    /**
     * The equation of any straight line, called a linear equation,
     * can be written as: y = mx + b, where m is the slope of the
     * line and b is the y-intercept
     * The y-intercept of this line is the value of y at the point
     * where the line crosses the y axis.
     * <p>
     * Slope = change in y-value/change in x-value
     */
    public Line(Point start, Point end) {
        double deltaY = end.y - start.y;
        double deltaX = end.x - start.x;

        slope = deltaY / deltaX;
        yIntercept = end.y - slope * end.x;
    }
}