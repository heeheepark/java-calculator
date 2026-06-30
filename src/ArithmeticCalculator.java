import operator.OperatorType;

import java.util.List;

public class ArithmeticCalculator<T extends Number> extends Calculator<Double> {

    public double calculate(char calcType, T num1, T num2) {
        double a = num1.doubleValue();
        double b = num2.doubleValue();

        return OperatorType.from(calcType).getOperator().operate(a, b);
    }

    private void validateDivisionByZero(double divisor) {
        if (divisor == 0.0) {
            throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }
    }

    public void printGreater(double input) {
        List<Double> list = getValues().stream().filter((s) -> s >= input).toList();
        for (Double v : list) {
            System.out.println(v);
        }
    }
}
