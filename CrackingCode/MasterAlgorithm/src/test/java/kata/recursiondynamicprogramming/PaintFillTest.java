package kata.recursiondynamicprogramming;

import org.junit.Test;

public class PaintFillTest {
    @Test
    public void paintFillTest() {
        PaintFill paintFill = new PaintFill();

        Color[][] colors = new Color[3][3];
        for (int row = 0; row < colors.length; row++) {
            for (int col = 0; col < colors[0].length; col++) {
                colors[row][col] = Color.RED;
                System.err.print(colors[row][col] + " ");
            }
            System.err.println();
        }
        paintFill.fillColor(colors, 2, 2, Color.GREEN);

        for (int row = 0; row < colors.length; row++) {
            for (int col = 0; col < colors[0].length; col++) {
                System.err.print(colors[row][col] + " ");
            }
            System.err.println();
        }
    }

}