import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LRUCacheTest {
    private LRUCache cache = new LRUCache(2);

    @Test
    public void testCache() {
        cache.put(1, 1);
        cache.put(2, 2);
        assertThat("get 1 and hit cache", cache.get(1), equalTo(1));

        cache.put(3, 3);    // evicts key 2
        assertThat("get 2 and miss cache", cache.get(2), equalTo(-1));

        cache.put(4, 4);    // evicts key 1
        assertThat("get 1 and miss cache", cache.get(1), equalTo(-1));

        cache.get(3);       // returns 3
        assertThat("get 3 and hit cache", cache.get(3), equalTo(3));
        assertThat("get 4 and hit cache", cache.get(4), equalTo(4));
    }
}
