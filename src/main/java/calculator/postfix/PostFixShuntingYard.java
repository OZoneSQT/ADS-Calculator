package calculator.postfix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PostFixShuntingYard {

    private final int leftExpression  = 0;
    private final int rightExpression = 1;

    private Map<String, int[]> operators = new HashMap<>();

    public PostFixShuntingYard() {
        operators.put("+", new int[] { 0, leftExpression });
        operators.put("-", new int[] { 0, leftExpression });
        operators.put("*", new int[] { 5, leftExpression });
        operators.put("/", new int[] { 5, leftExpression });
    }

    private boolean isOperator(String token) {
        return operators.containsKey(token);
    }

    private boolean isAssociative(String token, int type) {
        if (!isOperator(token)) {
            throw new IllegalArgumentException("Invalid token: " + token);
        } if (operators.get(token)[1] == type) {
            return true;
        }
        return false;
    }

    private int cmpPrecedence(String token1, String token2) {
        if (!isOperator(token1) || !isOperator(token2)) {
            throw new IllegalArgumentException("Invalid tokens: " + token1
                    + " " + token2);
        }
        return operators.get(token1)[0] - operators.get(token2)[0];
    }

    public String[] infixToRPN(String[] inputTokens) {
        ArrayList<String> out = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();

        for (String token : inputTokens) {
            if (isOperator(token)) {
                while (!stack.empty() && isOperator(stack.peek())) {
                    if ((isAssociative(token, leftExpression)         &&
                            cmpPrecedence(token, stack.peek()) <= 0) ||
                            (isAssociative(token, rightExpression)        &&
                                    cmpPrecedence(token, stack.peek()) < 0)) {
                        out.add(stack.pop());
                        continue;
                    }
                    break;
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);  //
            } else if (token.equals(")")) {
                while (!stack.empty() && !stack.peek().equals("(")) {
                    out.add(stack.pop());
                }
                stack.pop();
            } else {
                out.add(token);
            }
        }
        while (!stack.empty()) {
            out.add(stack.pop());
        }
        String[] output = new String[out.size()];
        return out.toArray(output);
    }

    private double RPNtoDouble(String[] tokens) {
        Stack<String> stack = new Stack<String>();

        for (String token : tokens) {
            if (!isOperator(token)) {
                stack.push(token);
            } else {
                Double d2 = Double.valueOf( stack.pop() );
                Double d1 = Double.valueOf( stack.pop() );

                Double result = token.compareTo("+") == 0 ? d1 + d2 :
                        token.compareTo("-") == 0 ? d1 - d2 :
                                token.compareTo("*") == 0 ? d1 * d2 :
                                        d1 / d2;

                stack.push( String.valueOf( result ));
            }
        }
        return Double.valueOf(stack.pop());
    }

    public double getResult(String[] tokens) {
        return RPNtoDouble(tokens);
    }

}