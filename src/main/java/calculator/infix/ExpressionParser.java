package calculator.infix;

public class ExpressionParser {
    private String[] operators = new String[]{"+", "-", "*", "/"};

    public ExpressionParser() {
    }


    public int leftPrecedence(String op) {
        if (op.equals("*"))
            return 3;
        else if (op.equals("/"))
            return 3;
        else if (op.equals("+"))
            return 1;
        else if (op.equals("-"))
            return 1;
        else
            return - 1;
    }

    public int rightPrecedence(String op)  {
        if (op.equals("*"))
            return 4;
        else if (op.equals("/"))
            return 4;
        else if (op.equals("+"))
            return 2;
        else if (op.equals("-"))
            return 2;
        else
            return - 1;
    }

    public boolean isOperator(String op) {
        boolean isOp = false;
        for (int i = 0; i < operators.length; i++)
            if (operators[i].equals(op))
                isOp = true;
        return isOp;
    }

    public boolean isInteger(String integer) {
        try {
            Integer.parseInt(integer);
            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }

}
