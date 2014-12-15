import java.util.List;

public class PatternMatcher {

    public String match(List<Tuple> tuples, int integer) {
        for (Tuple tuple : tuples) {
            if (tuple.getChecker().test(integer)) {
                return tuple.getValue().get();
            }
        }
        return "";
    }
}