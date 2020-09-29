package calculator.postfix;

import java.util.HashMap;
import java.util.Map;

public class PostFixExpressionParser {
    private final int leftExpression = 0;
    private final int rightExpression = 1;

    private Map<String, int[]> operators = new HashMap<>();

    public PostFixExpressionParser() {
        operators.put("+", new int[] { 0, leftExpression });
        operators.put("-", new int[] { 0, leftExpression });
        operators.put("*", new int[] { 5, leftExpression });
        operators.put("/", new int[] { 5, leftExpression });
    }

    public boolean isOperator(String token) {
        return operators.containsKey(token);
    }

    public boolean isRightExpression(String token, int type) {
        if (!isOperator(token)) {
            throw new IllegalArgumentException("Invalid token: " + token);
        } if (operators.get(token)[1] == type) {
            return true;
        }
        return false;
    }

    public int computeLeftExpression(String token1, String token2) {
        if (!isOperator(token1) || !isOperator(token2)) {
            throw new IllegalArgumentException("Invalid tokens: " + token1
                    + " " + token2);
        }
        return operators.get(token1)[0] - operators.get(token2)[0];
    }

    public int getLeftExpression() {
        return leftExpression;
    }

    public int getRightExpression() {
        return rightExpression;
    }
}
