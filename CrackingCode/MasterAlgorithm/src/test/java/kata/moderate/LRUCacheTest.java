package kata.moderate;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

    public LRUCache cache = new LRUCache(3);

    @Test
    public void canAddToCache() {
        cache.insertKeyValue("one", "valueOne");
        cache.insertKeyValue("two", "valueOne");
        cache.insertKeyValue("three", "valueOne");

        int actual = cache.map.size();
        Assert.assertEquals(3, actual);

        cache.insertKeyValue("four", "valueFour");
        Assert.assertEquals(3, actual);
    }

    @Test
    public void canRemoveFromCache() {
        cache.insertKeyValue("one", "valueOne");
        cache.insertKeyValue("two", "valueTwo");
        cache.insertKeyValue("three", "valueThree");

        cache.removeKey("two");

        int actual = cache.map.size();
        Assert.assertEquals(2, actual);
        String actualValue = cache.getValueByKey("two");
        Assert.assertNull(actualValue);
    }

    @Test
    public void canGetFromCache() {
        cache.insertKeyValue("one", "valueOne");
        cache.insertKeyValue("two", "valueTwo");
        cache.insertKeyValue("three", "valueThree");

        String actualValue = cache.getValueByKey("two");
        Assert.assertEquals("valueTwo", actualValue);
        Assert.assertEquals(cache.head.value, actualValue);
    }
}