package kata.sortingandsearching.sortedsearchnosize;

import java.util.ArrayList;
import java.util.List;

public class Listy {

    private List<Integer> listy = new ArrayList<>();

    public Listy() {
        listy.add(1);
        listy.add(3);
        listy.add(5);
        listy.add(6);
        listy.add(7);
        listy.add(9);
        listy.add(-1);
        listy.add(-1);
        listy.add(-1);
        listy.add(-1);
    }

    public int elementAt(int index) {
        return listy.get(index);
    }

}
