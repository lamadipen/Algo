package kata.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ReSpaceSolutionTest {

    @Test
    public void reSpcaeTest() {
        ReSpaceSolution reSpaceSolution = new ReSpaceSolution();
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("jess");
        dictionary.add("looked");
        dictionary.add("just");
        dictionary.add("like");
        dictionary.add("her");
        dictionary.add("brother");
        dictionary.add("tim");
//        String result = reSpaceSolution.reSpcae(dictionary, "jesslookedjustliketimherbrother");
        String result = reSpaceSolution.reSpcae(dictionary, "jesslooked");
        Assert.assertEquals("jess l o o k e d ", result);
    }

    @Test
    public void bestReSpcaeTest() {
        ReSpaceSolution reSpaceSolution = new ReSpaceSolution();
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("jess");
        dictionary.add("looked");
        dictionary.add("just");
        dictionary.add("like");
        dictionary.add("her");
        dictionary.add("brother");
        dictionary.add("tim");
        String result = reSpaceSolution.reSpcae(dictionary, "jesslookedjustliketimherbrother");
//        String result = reSpaceSolution.bestReSpace(dictionary, "jesslooked");
//        Assert.assertEquals("jess looked",result);
    }
}