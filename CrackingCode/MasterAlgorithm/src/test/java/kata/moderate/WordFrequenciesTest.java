package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

public class WordFrequenciesTest {

    @Test
    public void wordFrequencyTest() {
        WordFrequencies wordFrequencies = new WordFrequencies();

        int actual = wordFrequencies.getCount(new String[]{"bot", "God", "dog", "god", "mod", "God "}, "god");
        Assert.assertEquals(3, actual);
    }

    @Test
    public void wordFrequencyRepetitiveCallTest() {
        WordFrequencies wordFrequencies = new WordFrequencies();
        wordFrequencies.setUpDictionary(new String[]{"bot", "God", "dog", "god", "mod", "God "});
        int actual = wordFrequencies.getCountRepetitiveCall("god");
        Assert.assertEquals(3, actual);

        int actual1 = wordFrequencies.getCountRepetitiveCall("mod");
        Assert.assertEquals(1, actual1);
    }

}