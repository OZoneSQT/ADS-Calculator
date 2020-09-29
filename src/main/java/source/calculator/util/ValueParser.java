package source.calculator.util;

public class ValueParser {
    private String[] operators = new String[]{"+", "-", "*", "/"};

    public int getValueASCII(String element) {
        int elementValue = 0;
        elementValue = element.charAt(0);
        return elementValue;
    }

    public int getIntegerValue(String integer) {
        Integer result = 0;
        int value = result.valueOf(integer);
        return value;
    }

    //TODO This method throws the NumberFormatException
    public double getDoubleValue(String integer) {
        Integer result = 0;
        double value = 0.0;

        try {
            value = (int) result.valueOf(integer);
        } catch (NumberFormatException e) {
            System.out.println("ValueParser.getDoubleValue throws NumberFormatException");
        }

        return value;
    }

    public boolean isInteger(String integer) {
        boolean result = false;
        try {
            Integer.parseInt(integer);
            result = true;
        } catch (NullPointerException e) {
            System.out.println("ValueParser.isInteger throws NullPointerException");
        }
        return result;
    }

    public boolean isOperator(String operator) {
        boolean isOperator = false;
        for (int i = 0; i < operators.length; i++)
            if (operators[i].equals(operator))
                isOperator = true;
        return isOperator;
    }

}
