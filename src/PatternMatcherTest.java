import org.junit.Before;
import org.junit.Test;

import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

public class PatternMatcherTest {

    private PatternMatcher patternMatcher;
    private Predicate<Integer> positiveChecker;
    private Predicate<Integer> negativeChecker;
    private Supplier<String> yay;
    private Supplier<String> nay;
    private Supplier<String> boo;

    @Before
    public void setUp() throws Exception {
        patternMatcher = new PatternMatcher();
        positiveChecker = t -> t > 0;
        negativeChecker = t -> t < 0;
        yay = () -> "yay";
        nay = () -> "nay";
        boo = () -> "boo";

    }
    @Test
    public void returnYayIfPositive() throws Exception {
        assertEquals(patternMatcher.match(positiveChecker, negativeChecker, yay, nay, boo, 3), "yay");
    }

    @Test
    public void returnNayIfNegative() throws Exception {
        assertEquals(patternMatcher.match(positiveChecker, negativeChecker, yay, nay, boo, -4), "nay");
    }

    @Test
    public void returnBooIfZero() throws Exception {
        assertEquals(patternMatcher.match(positiveChecker, negativeChecker, yay, nay, boo, 0), "boo");
    }
}