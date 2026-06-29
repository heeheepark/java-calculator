import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator extends Calculator<Integer> {
    private static final List<String> CALC_TYPES = List.of("+", "-", "*", "/");

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

    public void validateCalcType(String calcType) {
        if (!CALC_TYPES.contains(calcType)) {
            throw new IllegalArgumentException("사칙연산 기호는 [+, -, *, /] 중 하나여야 합니다.");
        }
    }

    public void validateNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("숫자는 0 이상의 정수여야 합니다.");
        }
    }
}
