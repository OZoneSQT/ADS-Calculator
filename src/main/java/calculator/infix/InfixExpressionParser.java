package calculator.infix;

public class InfixExpressionParser {
    private String[] operators = new String[]{"+", "-", "*", "/"};

    public InfixExpressionParser() {
    }

    public int leftPrecedence(String operator) {
        int op;
        if (operator.equals("*")) {
            op = 3;
        } else if (operator.equals("/")) {
            op = 3;
        } else if (operator.equals("+")) {
            op = 1;
        } else if (operator.equals("-")) {
            op = 1;
        } else {
            op =  -1;
        }
        return op;
    }

    public int rightPrecedence(String operator)  {
        int op;
        if (operator.equals("*")) {
            op = 4;
        } else if (operator.equals("/")) {
            op = 4;
        } else if (operator.equals("+")) {
            op = 2;
        } else if (operator.equals("-")) {
            op = 2;
        } else {
            op = - 1;
        }
        return op;
    }

    public boolean isOperator(String operator) {
        boolean isOperator = false;
        for (int i = 0; i < operators.length; i++)
            if (operators[i].equals(operator)) {
                isOperator = true;
            }
        return isOperator;
    }

    public boolean isInteger(String integer) {
        try {
            Integer.parseInt(integer);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

}
