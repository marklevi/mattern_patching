import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
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
    private List<Tuple> tuples;
    private Predicate<Integer> zeroChecker;

    @Before
    public void setUp() throws Exception {
        patternMatcher = new PatternMatcher();
        positiveChecker = t -> t > 0;
        negativeChecker = t -> t < 0;
        zeroChecker = t -> t == 0;
        yay = () -> "yay";
        nay = () -> "nay";
        boo = () -> "boo";

        Tuple positiveTuple = new Tuple(positiveChecker, yay);
        Tuple negativeTuple = new Tuple(negativeChecker, nay);
        Tuple zeroTuple = new Tuple(zeroChecker, boo);

        tuples = Arrays.asList(positiveTuple, negativeTuple, zeroTuple);

    }

    @Test
    public void returnYayIfPositive() throws Exception {
        assertEquals(patternMatcher.match(tuples, 3), "yay");
    }

    @Test
    public void returnNayIfNegative() throws Exception {
        assertEquals(patternMatcher.match(tuples, -4), "nay");
    }

    @Test
    public void returnBooIfZero() throws Exception {
        assertEquals(patternMatcher.match(tuples, 0), "boo");
    }
}