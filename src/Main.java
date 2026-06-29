import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<String> CALC_TYPES = List.of("+", "-", "*", "/");

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = scanner.nextInt();
            validateNumber(num1);

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = scanner.nextInt();
            validateNumber(num2);
            scanner.nextLine();

            System.out.print("사칙연산 기호를 입력하세요: ");
            String calcType = scanner.nextLine();
            validateCalcType(calcType);

            // 사칙연산 수행
            int result = calculate(calcType, num1, num2);
            System.out.println("결과: " + result);

            if (values.size() >= 10) {
                System.out.println("가장 먼저 연산된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                String removeCommand = scanner.nextLine();

                if ("remove".equals(removeCommand)) {
                    values.remove(0);
                }
            }

            values.add(result);

            System.out.println("저장된 연산 결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String inquiryCommand = scanner.nextLine();
            if ("inquiry".equals(inquiryCommand)) {
                for (Integer value : values) {
                    System.out.println(value);
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitCommand = scanner.nextLine();
            if ("exit".equals(exitCommand)) {
                break;
            }
        }

        scanner.close();
    }

    private static int calculate(String calcType, int num1, int num2) {
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

    private static void validateDivisionByZero(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }
    }

    private static void validateCalcType(String calcType) {
        if (!CALC_TYPES.contains(calcType)) {
            throw new IllegalArgumentException("사칙연산 기호는 [+, -, *, /] 중 하나여야 합니다.");
        }
    }

    private static void validateNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("숫자는 0 이상의 정수여야 합니다.");
        }
    }
}