import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PatternMatcherTest {

    private PatternMatcher patternMatcher = new PatternMatcher();

    @Test
    public void returnYayIfPositive() throws Exception {
        assertEquals(patternMatcher.match(3), "yay");
    }

    @Test
    public void returnNayIfNegative() throws Exception {
        assertEquals(patternMatcher.match(-4), "nay");
    }

    @Test
    public void returnBooIfZero() throws Exception {
        assertEquals(patternMatcher.match(0), "boo");
    }
}