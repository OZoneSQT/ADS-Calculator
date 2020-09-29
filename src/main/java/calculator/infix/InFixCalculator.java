package calculator.infix;

import calculator.nodes.*;

import java.util.StringTokenizer;

/*
 * This class parses the given expression into a parse tree
 */
public class InFixCalculator {
  private StringTokenizer lexAnalyser;
  private String lexItem;
  private ExpressionParser expressionParser = new ExpressionParser();

  public InFixCalculator(String expression) {
    lexAnalyser = new StringTokenizer(expression);
  }

  public TreeNode parse() {
    getNextToken();
    return this.computeExpression(0);
  }

  private TreeNode computeExpression(int priority)  {
    TreeNode lhs = handleInteger();
    if (lhs == null) return null;

    while (expressionParser.isOperator(lexItem) && priority <= expressionParser.leftPrecedence(lexItem))  {
      String op = lexItem;
      getNextToken();
      TreeNode rhs = computeExpression(expressionParser.rightPrecedence(op));
      if (rhs == null) {
        System.out.print("InFixCalculator.computeExpression - ");
        System.out.println("Error in expression");
        System.exit(1);
      }
      else  {
        TreeNode temp = lhs;
        if(op.equals("+"))
          lhs = new AdditionNode(temp, rhs);
        else
        if(op.equals("-"))
          lhs = new SubtractionNode(temp, rhs);
        else
        if(op.equals("*"))
          lhs = new MultiplicationNode(temp, rhs);
        else
        if(op.equals("/"))
          lhs = new DivisionNode(temp, rhs);
        else
          System.out.print("InFixCalculator.computeExpression - ");
          System.out.println("ERROR in INPUT!");
      }
    }
    return lhs;
  }

  private TreeNode handleInteger() {
    TreeNode nodep = null;

    if (expressionParser.isInteger(lexItem))  {
      nodep = new NumericNode(Integer.parseInt(lexItem));
      if (this.lexAnalyser.hasMoreTokens())
        getNextToken();
      else
        this.lexItem = null;
    }
    else  {
      System.out.print("InFixCalculator.parseInteger - ");
      System.out.println("Error in expression " + lexItem);
      System.exit(1);
    }
    return nodep;
  }

  private void getNextToken() {
    lexItem = lexAnalyser.nextToken();
  }

}
