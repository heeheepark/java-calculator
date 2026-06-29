import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Integer> values;
    private final List<Double> circleAreas ;

    public Calculator() {
        this.values = new ArrayList<>();
        this.circleAreas = new ArrayList<>();
    }

    public int calculate(String calcType, int num1, int num2) {
        switch (calcType) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                validateDivisionByZero(num2);
                return num1 / num2;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
    }

    private void validateDivisionByZero(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }
    }

    public List<Integer> getValues() {
        return values;
    }

    public int getValuesSize() {
        return values.size();
    }

    public void addValue(int value) {
        values.add(value);
    }

    public void removeFirstValue() {
        values.remove(0);
    }

    public double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public void addCircleArea(double circleArea) {
        circleAreas.add(circleArea);
    }

    public List<Double> getCircleAreas() {
        return circleAreas;
    }
}
