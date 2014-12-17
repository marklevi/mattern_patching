import java.util.List;

public class PatternMatcher {

    private List<Tuple> tuples = TupleBuilder.buildTuples();

    public String match(int integer) {
        for (Tuple tuple : tuples) {
            if (tuple.getChecker().test(integer)) {
                return tuple.getValue().get();
            }
        }
        return "";
    }
}