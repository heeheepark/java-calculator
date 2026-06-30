import operator.OperatorType;

import java.util.List;

public class ArithmeticCalculator<T extends Number> extends Calculator<Double> {

    public double calculate(String calcType, T num1, T num2) {
        double a = num1.doubleValue();
        double b = num2.doubleValue();

        switch (calcType) {
            case "+":
                return OperatorType.ADD.operate(a, b);
            case "-":
                return OperatorType.SUBTRACT.operate(a, b);
            case "*":
                return OperatorType.MULTIPLY.operate(a, b);
            case "/":
                validateDivisionByZero(b);
                return OperatorType.DIVIDE.operate(a, b);
            case "%":
                return OperatorType.MOD.operate(a, b);
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
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
