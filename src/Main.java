import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<String> CALC_TYPES = List.of("+", "-", "*", "/");

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("실행 타입을 선택해 주세요. [1. 원의 넓이 구하기 , 2. 사칙연산]");

            int type = scanner.nextInt();
            switch (type) {
                case 1:
                    System.out.print("반지름을 입력하세요: ");
                    double radius = scanner.nextDouble();
                    double circleArea = calculator.calculateCircleArea(radius);
                    System.out.println("원의 넓이: " + circleArea);
                    scanner.nextLine();

                    calculator.addCircleArea(circleArea);

                    List<Double> circleAreas = calculator.getCircleAreas();
                    for (Double area : circleAreas) {
                        System.out.println(area);
                    }

                    break;
                case 2:
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
                    int result = calculator.calculate(calcType, num1, num2);
                    System.out.println("결과: " + result);

                    if (calculator.getValuesSize() >= 10) {
                        System.out.println("가장 먼저 연산된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                        String removeCommand = scanner.nextLine();

                        if ("remove".equals(removeCommand)) {
                            calculator.removeFirstValue();
                        }
                    }

                    calculator.addValue(result);

                    System.out.println("저장된 연산 결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    String inquiryCommand = scanner.nextLine();
                    if ("inquiry".equals(inquiryCommand)) {
                        List<Integer> values = calculator.getValues();
                        for (Integer value : values) {
                            System.out.println(value);
                        }
                    }

                    break;
                default:
                    throw new IllegalArgumentException("표시된 항목 중 선택해주세요.");
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitCommand = scanner.nextLine();
            if ("exit".equals(exitCommand)) {
                break;
            }
        }

        scanner.close();
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