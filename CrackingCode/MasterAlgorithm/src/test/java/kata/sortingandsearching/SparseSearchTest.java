package kata.sortingandsearching;

import org.junit.Assert;
import org.junit.Test;

public class SparseSearchTest {
    @Test
    public void spareSearchHandleNullEmptyArrayTest() {
        SparseSearch sparseSearch = new SparseSearch();
        String[] strings = new String[0];
        int actual = sparseSearch.search(null, "ball");
        Assert.assertEquals(-1, actual);

        int actualEmptyTarget = sparseSearch.search(strings, "");
        Assert.assertEquals(-1, actualEmptyTarget);

        int actualEmptyArray = sparseSearch.search(strings, null);
        Assert.assertEquals(-1, actualEmptyArray);
    }


    @Test
    public void spareSearchArrayTest() {
        SparseSearch sparseSearch = new SparseSearch();
        String[] strings = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        int actual = sparseSearch.search(strings, "ball");

        Assert.assertEquals(4, actual);
    }

    @Test
    public void searchArrayTest() {
        SparseSearch sparseSearch = new SparseSearch();
        String[] strings = new String[]{"at", "ball", "car", "dad"};
        int actual = sparseSearch.search(strings, "ball");

        Assert.assertEquals(1, actual);
    }
}