package operator;

public enum OperatorType {

    ADD {
        @Override
        public double operate(double a, double b) {
            return a + b;
        }
    },

    SUBTRACT {
        @Override
        public double operate(double a, double b) {
            return a - b;
        }
    },

    MULTIPLY {
        @Override
        public double operate(double a, double b) {
            return a * b;
        }
    },

    DIVIDE {
        @Override
        public double operate(double a, double b) {
            return a / b;
        }
    },

    MOD {
        @Override
        public double operate(double a, double b) {
            return a % b;
        }
    };

    public abstract double operate(double a, double b);
}
