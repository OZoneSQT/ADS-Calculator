package calculator.postfix;

import java.util.ArrayList;
import java.util.Stack;

public class PostFixShuntingYard {
    private PostFixExpressionParser postFixExpressionParser = new PostFixExpressionParser();

    public PostFixShuntingYard() {
    }

    public String[] infixToPostFix(String[] inputTokens) {
        ArrayList<String> out = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String token : inputTokens) {
            if (postFixExpressionParser.isOperator(token)) {
                while (!stack.isEmpty() && postFixExpressionParser.isOperator(stack.peek())) {
                    if ((postFixExpressionParser.isRightExpression(token, postFixExpressionParser.getLeftExpression()) && postFixExpressionParser.computeLeftExpression(token, stack.peek()) <= 0) ||
                            (postFixExpressionParser.isRightExpression(token, postFixExpressionParser.getRightExpression()) && postFixExpressionParser.computeLeftExpression(token, stack.peek()) < 0)) {
                        out.add(stack.pop());
                        continue;
                    }
                    break;
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);  //
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    out.add(stack.pop());
                }
                stack.pop();
            } else {
                out.add(token);
            }
        }
        while (!stack.isEmpty()) {
            out.add(stack.pop());
        }
        String[] output = new String[out.size()];
        return out.toArray(output);
    }

}