import java.util.function.Predicate;
import java.util.function.Supplier;

public class Tuple {
    private final Predicate<Integer> checker;
    private final Supplier<String> value;

    public Tuple(Predicate<Integer> checker, Supplier<String> value) {
        this.checker = checker;
        this.value = value;
    }

    public Predicate<Integer> getChecker() {
        return checker;
    }

    public Supplier<String> getValue() {
        return value;
    }
}
