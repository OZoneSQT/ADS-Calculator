package calculator;

import calculator.nodes.TreeNode;
import calculator.nodes.numeric.NumericNode;
import calculator.util.*;

import java.util.StringTokenizer;

public class Calculator {

    private StringTokenizer leftExpressionAnalyser;
    private String[] operators = new String[]{"+", "-", "*", "/"};
    private String leftExpression;
    private Operate operate;

    public Calculator(String expression, StackInterface stackInterface) {
        leftExpressionAnalyser = new StringTokenizer(expression);
        operate = new Operate(expression, stackInterface);
    }

    public TreeNode compute() {
        getNextToken();
        return this.parseExpression(0);
    }

    private TreeNode parseExpression(int priority)  {
        TreeNode treeNode = parseInteger();
        if (treeNode == null) return null;

        while (isOperator(leftExpression) && priority <= precedence(leftExpression))  {
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
                if(operator.equals("+"))
                    operate.addition(leftExpression, rightExpression);
                else  if(operator.equals("-"))
                    operate.subtraction(leftExpression, rightExpression);
                else  if(operator.equals("*"))
                    operate.multiplication(leftExpression, rightExpression);
                else if(operator.equals("/"))
                    operate.division(leftExpression, rightExpression);
                else
                    // System.out.print("Calculator.parseExpression - ");
                    System.out.println("ERROR in INPUT!");
            }
        }
        return treeNode;
    }

    private TreeNode parseInteger() {
        TreeNode numeric = null;

        if (this.isInteger(leftExpression))  {
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

    /*
    Operators: DEC  ASCII
               42  =  *
               43  =  +
               45  =  -
               47  =  /
    */
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

    private boolean isInteger(String integer) {
        try {
            Integer.parseInt(integer);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private boolean isOperator(String operator) {
        boolean isOperator = false;
        for (int i = 0; i < operators.length; i++)
            if (operators[i].equals(operator))
                isOperator = true;
        return isOperator;
    }

    private void getNextToken() {
        leftExpression = leftExpressionAnalyser.nextToken();
    }

}
