import java.util.ArrayList;
import java.util.List;

public class Calculator<T> {
    private List<T> values;

    public Calculator() {
        this.values = new ArrayList<>();
    }

    public List<T> getValues() {
        return values;
    }

    public int getValuesSize() {
        return values.size();
    }

    public void addValue(T value) {
        values.add(value);
    }

    public void removeFirstValue() {
        values.remove(0);
    }
}
