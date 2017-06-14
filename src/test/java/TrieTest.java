import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TrieTest {
    private Trie trie = new Trie();

    @Test
    public void testSearch() {
        trie.insert("hello");
        assertThat("hello should be in the trie", trie.search("hello"), equalTo(true));
    }

    @Test
    public void testStartWith() {
        trie.insert("university");
        assertThat("should return true when search start with uni", trie.startWith("uni"), equalTo(true));
    }
}
