package operator;

public enum OperatorType {

    ADD('+', new AddOperator()),
    SUBTRACT('-', new SubtractOperator()),
    MULTIPLY('*', new MultiplyOperator()),
    DIVIDE('/', new DivideOperator()),
    MOD('%', new ModOperator());

    private final char calType;
    private final Operator operator;

    OperatorType(char calType, Operator operator) {
        this.calType = calType;
        this.operator = operator;
    }

    public Operator getOperator() {
        return operator;
    }

    public static OperatorType from(char calcType) {
        for (OperatorType type : values()) {
            if (type.calType == calcType) {
                return type;
            }
        }

        throw new IllegalArgumentException("일치하는 타입이 없습니다.");
    }
}
