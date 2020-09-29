package source.calculator;

import source.calculator.nodes.TreeNode;
import source.calculator.nodes.numeric.NumericNode;
import source.calculator.util.*;

import java.util.StringTokenizer;

public class Calculator {
    private StringTokenizer leftExpressionAnalyser;
    private String leftExpression;
    private Operate operate;
    private ValueParser valueParser;

    public Calculator(String expression, StackInterface stackInterface) {
        leftExpressionAnalyser = new StringTokenizer(expression);
        operate = new Operate(expression, stackInterface);
        valueParser = new ValueParser();
    }

    public TreeNode compute() {
        getNextToken();
        return this.parseExpression(0);
    }

    private TreeNode parseExpression(int priority)  {
        TreeNode treeNode = parseInteger();
        if (treeNode == null) return null;

        while (valueParser.isOperator(leftExpression) && priority <= precedence(leftExpression))  {
            String operator = leftExpression;
            getNextToken();
            TreeNode rightExpression = parseExpression(precedence(operator));
            if (rightExpression == treeNode) {
                // System.out.print("Calculator.parseExpression - ");
                System.out.println("Error in expression");
                System.exit(1);
            }
            else  {
                TreeNode leftExpression = treeNode;
                if(operator.equals("+")) {
                    operate.addition(leftExpression, rightExpression);
                } else if(operator.equals("-")) {
                    operate.subtraction(leftExpression, rightExpression);
                } else if(operator.equals("*")) {
                    operate.multiplication(leftExpression, rightExpression);
                } else if(operator.equals("/")) {
                    operate.division(leftExpression, rightExpression);
                } else {
                    // System.out.print("Calculator.parseExpression - ");
                    System.out.println("ERROR in INPUT!");
                }
            }
        }
        return treeNode;
    }

    private TreeNode parseInteger() {
        TreeNode numeric = null;

        if (valueParser.isInteger(leftExpression))  {
            numeric = new NumericNode(new Integer(leftExpression).intValue());
            if (this.leftExpressionAnalyser.hasMoreTokens())
                getNextToken();
            else {
                this.leftExpression = null;
            }
        } else  {
            // System.out.print("Calculator.parseInteger - ");
            System.out.print("Error in expression");
            // System.out.println(" " + leftExpression);
            System.exit(1);
        }
        return numeric;
    }

    private int precedence(String operator) {
        if (operator.equals("*")) {
            return 3;
        } else if (operator.equals("/")) {
            return 3;
        } else if (operator.equals("+")) {
            return 1;
        } else if (operator.equals("-")) {
            return 1;
        } else {
            return - 1;
        }
    }

    private void getNextToken() {
        leftExpression = leftExpressionAnalyser.nextToken();
    }

}
