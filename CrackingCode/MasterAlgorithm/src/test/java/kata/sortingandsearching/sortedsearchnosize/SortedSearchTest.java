package kata.sortingandsearching.sortedsearchnosize;

import org.junit.Assert;
import org.junit.Test;

public class SortedSearchTest {

    @Test
    public void searchTest() {
        SortedSearch sortedSearch = new SortedSearch();

        int actual = sortedSearch.search(new Listy(), 9);
        Assert.assertEquals(5, actual);

        int actualNoFound = sortedSearch.search(new Listy(), 10);
        Assert.assertEquals(-1, actualNoFound);
    }

}