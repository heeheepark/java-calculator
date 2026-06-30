import operator.OperatorType;

public class ArithmeticCalculator extends Calculator<Integer> {

    public int calculate(String calcType, int num1, int num2) {
        switch (calcType) {
            case "+":
                return OperatorType.ADD.operate(num1, num2);
            case "-":
                return OperatorType.SUBTRACT.operate(num1, num2);
            case "*":
                return OperatorType.MULTIPLY.operate(num1, num2);
            case "/":
                validateDivisionByZero(num2);
                return OperatorType.DIVIDE.operate(num1, num2);
            case "%":
                return OperatorType.MOD.operate(num1, num2);
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
    }

    private void validateDivisionByZero(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }
    }

    public void validateNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("숫자는 0 이상의 정수여야 합니다.");
        }
    }
}
