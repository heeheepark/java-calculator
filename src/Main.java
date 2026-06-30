import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>();
        CircleCalculator circleCalculator = new CircleCalculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("실행 타입을 선택해 주세요. [1. 원의 넓이 구하기 , 2. 사칙연산]");

            int type = scanner.nextInt();
            switch (type) {
                case 1:
                    System.out.print("반지름을 입력하세요: ");
                    double radius = scanner.nextDouble();
                    double circleArea = circleCalculator.calculateCircleArea(radius);
                    System.out.println("원의 넓이: " + circleArea);
                    scanner.nextLine();

                    circleCalculator.addValue(circleArea);

                    List<Double> circleAreas = circleCalculator.getValues();
                    for (Double area : circleAreas) {
                        System.out.println(area);
                    }

                    break;
                case 2:
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    double num1 = scanner.nextDouble();

                    System.out.print("두 번째 숫자를 입력하세요: ");
                    double num2 = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char calcType = scanner.nextLine().charAt(0);

                    // 사칙연산 수행
                    Double result = arithmeticCalculator.calculate(calcType, num1, num2);
                    System.out.println("결과: " + result);

                    if (arithmeticCalculator.getValuesSize() >= 10) {
                        System.out.println("가장 먼저 연산된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                        String removeCommand = scanner.nextLine();

                        if ("remove".equals(removeCommand)) {
                            arithmeticCalculator.removeFirstValue();
                        }
                    }

                    arithmeticCalculator.addValue(result);

                    System.out.println("저장된 연산 결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    String inquiryCommand = scanner.nextLine();
                    if ("inquiry".equals(inquiryCommand)) {
                        List<Double> values = arithmeticCalculator.getValues();
                        for (Double value : values) {
                            System.out.println(value);
                        }
                    }

                    System.out.println("더 큰 값을 조회하시겠습니까? (yes 입력 시 조회)");
                    String inputCommand = scanner.nextLine();
                    if ("yes".equals(inputCommand)) {
                        System.out.print("숫자를 입력하세요: ");
                        Double input = scanner.nextDouble();
                        arithmeticCalculator.printGreater(input);
                        scanner.nextLine();
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


}