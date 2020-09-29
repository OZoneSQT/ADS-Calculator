package calculator.infix;

import calculator.nodes.*;
import calculator.nodes.numeric.NumericNode;
import calculator.nodes.operator.AdditionNode;
import calculator.nodes.operator.DivisionNode;
import calculator.nodes.operator.MultiplicationNode;
import calculator.nodes.operator.SubtractionNode;

import java.util.StringTokenizer;

public class InFixCalculator {
  private StringTokenizer leftExpressionAnalyser;
  private String leftExpressionItem;
  private InfixExpressionParser infixExpressionParser = new InfixExpressionParser();

  public InFixCalculator(String expression) {
    leftExpressionAnalyser = new StringTokenizer(expression);
  }

  public TreeNode parse() {
    getNextToken();
    return this.computeExpression(0);
  }

  private TreeNode computeExpression(int priority)  {
    TreeNode leftNode = handleInteger();
    if (leftNode == null) return null;

    while (infixExpressionParser.isOperator(leftExpressionItem) && priority <= infixExpressionParser.leftPrecedence(leftExpressionItem))  {
      String operand = leftExpressionItem;
      getNextToken();
      TreeNode rightNode = computeExpression(infixExpressionParser.rightPrecedence(operand));
      if (rightNode == null) {
        System.out.print("InFixCalculator.computeExpression - ");
        System.out.println("Error in expression");
        System.exit(1);
      } else {
        TreeNode temp = leftNode;
        if(operand.equals("+")) {
          leftNode = new AdditionNode(temp, rightNode);
        } else if(operand.equals("-")) {
          leftNode = new SubtractionNode(temp, rightNode);
        } else if(operand.equals("*")) {
          leftNode = new MultiplicationNode(temp, rightNode);
        } else if(operand.equals("/")) {
          leftNode = new DivisionNode(temp, rightNode);
        } else {
          System.out.print("InFixCalculator.computeExpression - ");
          System.out.println("ERROR in INPUT!");
        }
      }
    }
    return leftNode;
  }

  private TreeNode handleInteger() {
    TreeNode numeric = null;

    if (infixExpressionParser.isInteger(leftExpressionItem)) {
      numeric = new NumericNode(Integer.parseInt(leftExpressionItem));
      if (this.leftExpressionAnalyser.hasMoreTokens()) {
        getNextToken();
      } else {
        this.leftExpressionItem = null;
      }
    } else {
      System.out.print("InFixCalculator.parseInteger - ");
      System.out.println("Error in expression " + leftExpressionItem);
      System.exit(1);
    }
    return numeric;
  }

  private void getNextToken() {
    leftExpressionItem = leftExpressionAnalyser.nextToken();
  }

}
