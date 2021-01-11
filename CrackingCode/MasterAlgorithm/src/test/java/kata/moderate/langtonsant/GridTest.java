package kata.moderate.langtonsant;

import org.junit.Test;

public class GridTest {

    @Test
    public void printKGrid() {
        Grid grid = new Grid();
        grid.printKGrid(10);
    }


    @Test
    public void printKGridWithSet() {
        GridWithSet grid = new GridWithSet();
        grid.printKGrid(10);
    }
}
