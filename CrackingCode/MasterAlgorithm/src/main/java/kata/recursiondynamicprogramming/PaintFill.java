package kata.recursiondynamicprogramming;

/**
 * Recursion and dynamic programming
 * Paint Fill
 * CC: pg 136 Q: 8.10
 */
public class PaintFill {
    public boolean fillColor(Color[][] colors, int row, int col, Color newColor) {
        if (colors[row][col] == newColor) {
            return false;
        }
        return fillColor(colors, row, col, Color.GREEN, colors[row][col]);
    }

    public boolean fillColor(Color[][] colors, int row, int col, Color newColor, Color oldColor) {
        if (row < 0 || row >= colors.length || col < 0 || col >= colors[0].length) {
            return false;
        }
        if (colors[row][col] == oldColor) {
            colors[row][col] = newColor;
            fillColor(colors, row - 1, col, newColor, oldColor);
            fillColor(colors, row + 1, col, newColor, oldColor);
            fillColor(colors, row, col - 1, newColor, oldColor);
            fillColor(colors, row, col + 1, newColor, oldColor);
        }
        return true;
    }
}

enum Color {
    RED,
    BLUE,
    GREEN,
    YELLOW
}
