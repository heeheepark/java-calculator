package operator;

public enum OperatorType {
    ADD {
        @Override
        public int operate(int num1, int num2) {
            return num1 + num2;
        }
    },
    SUBTRACT {
        @Override
        public int operate(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY {
        @Override
        public int operate(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE {
        @Override
        public int operate(int num1, int num2) {
            return num1 / num2;
        }
    },
    MOD {
        @Override
        public int operate(int num1, int num2) {
            return num1 % num2;
        }
    };

    public abstract int operate(int a, int b);
}
