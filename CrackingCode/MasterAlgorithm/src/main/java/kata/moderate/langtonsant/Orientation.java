package kata.moderate.langtonsant;

public enum Orientation {
    left, up, right, down;

    public Orientation turn(boolean clockwise) {
        if (this == left) {
            return clockwise ? up : down;
        } else if (this == up) {
            return clockwise ? right : left;
        } else if (this == right) {
            return clockwise ? down : up;
        } else {
            return clockwise ? left : right;
        }
    }

    @Override
    public String toString() {
        if (this == left) {
            return "\u2190";
        } else if (this == up) {
            return "\u2191";
        } else if (this == right) {
            return "\u2192";
        } else {
            return "\u2193";
        }
    }
}
