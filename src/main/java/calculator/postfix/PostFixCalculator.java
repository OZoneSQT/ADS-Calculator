package calculator.postfix;

import calculator.util.StackInterface;
import calculator.util.StackLIFO;

public class PostFixCalculator {
    private PostFixExpressionParser postFixExpressionParser = new PostFixExpressionParser();

    public PostFixCalculator() {
    }

    public double getResult(String[] tokens) {
        return postFixToDouble(tokens);
    }

    private double postFixToDouble(String[] tokens) {
        StackInterface<String> stackInterface = new StackLIFO<>();

        for (String token : tokens) {
            if (!postFixExpressionParser.isOperator(token)) {
                stackInterface.push(token);
            } else {
                Double aDouble = Double.valueOf(stackInterface.pop());
                Double bDouble = Double.valueOf(stackInterface.pop());

                Double result = token.compareTo("+") == 0 ? bDouble + aDouble :
                        token.compareTo("-") == 0 ? bDouble - aDouble :
                                token.compareTo("*") == 0 ? bDouble * aDouble :
                                        bDouble / aDouble;

                stackInterface.push(String.valueOf(result));
            }
        }
        return Double.valueOf(stackInterface.pop());
    }

}