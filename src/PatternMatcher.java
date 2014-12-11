import java.util.function.Predicate;
import java.util.function.Supplier;

public class PatternMatcher {

    public String match(Predicate<Integer> positiveChecker, Predicate<Integer> negativeChecker, Supplier<String> yay, Supplier<String> nay, Supplier<String> boo, Integer integer) {
        if (positiveChecker.test(integer)) {
            return yay.get();
        } else if (negativeChecker.test(integer)) {
            return nay.get();
        }
        return boo.get();
    }

    public static void main(String[] args) {
        final Predicate<Integer> positiveChecker = t -> t > 0;
        final Predicate<Integer> negativeChecker = t -> t < 0;

        Supplier<String> yay = () -> "yay";
        Supplier<String> nay = () -> "nay";
        Supplier<String> boo = () -> "boo";

        System.out.println(new PatternMatcher().match(positiveChecker, negativeChecker, yay, nay, boo, 3));
    }
}