import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TupleBuilder {

    public static List<Tuple> buildTuples() {

        Predicate<Integer> positiveChecker = t -> t > 0;
        Predicate<Integer> negativeChecker = t -> t < 0;
        Predicate<Integer> zeroChecker = t -> t == 0;
        Supplier<String> yay = () -> "yay";
        Supplier<String> nay = () -> "nay";
        Supplier<String> boo = () -> "boo";

        Tuple positiveTuple = new Tuple(positiveChecker, yay);
        Tuple negativeTuple = new Tuple(negativeChecker, nay);
        Tuple zeroTuple = new Tuple(zeroChecker, boo);

        return Arrays.asList(positiveTuple, negativeTuple, zeroTuple);
    }
}
