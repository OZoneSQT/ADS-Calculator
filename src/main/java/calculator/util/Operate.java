package calculator.util;

import calculator.nodes.TreeNode;
import calculator.nodes.operator.AdditionNode;
import calculator.nodes.operator.DivisionNode;
import calculator.nodes.operator.MultiplicationNode;
import calculator.nodes.operator.SubtractionNode;

public class Operate {
    private QueueInterface queueInterface;
    private StackInterface stackInterface;
    private CharToASCII charToASCII;
    private double totalSum;

    public Operate(String expression, StackInterface stackInterface) {
        this.totalSum = 0;
        charToASCII = new CharToASCII();
        queueInterface = new QueueFIFO(expression.length());
        this.stackInterface = stackInterface;
    }

    public TreeNode addition(TreeNode rightExpression, TreeNode leftExpression) {
        TreeNode treeNode = new AdditionNode(leftExpression, rightExpression);
        totalSum = computeOperator(treeNode, leftExpression);
        return treeNode;
    }

    public TreeNode subtraction(TreeNode leftExpression, TreeNode rightExpression) {
        TreeNode treeNode = new SubtractionNode(leftExpression, rightExpression);
        totalSum = computeOperator(treeNode, leftExpression);
        return treeNode;
    }

    public TreeNode multiplication(TreeNode leftExpression, TreeNode rightExpression) {
        TreeNode treeNode = new MultiplicationNode(leftExpression, rightExpression);
        totalSum = computeOperator(treeNode, leftExpression);
        return treeNode;
    }

    public TreeNode division(TreeNode leftExpression, TreeNode rightExpression) {
        TreeNode treeNode = new DivisionNode(leftExpression, rightExpression);
        totalSum = computeOperator(treeNode, leftExpression);
        return treeNode;
    }

    private double computeOperator(TreeNode treeNode, TreeNode leftExpression) {
        double result = 0.0;
        if (queueInterface.isEmpty()) {
            queueInterface.enqueue(getDouble(leftExpression.toString()));
        } else {
            result = treeNode.computeOperator(getDouble(leftExpression.toString()), (double) queueInterface.dequeue());
        }
        stackInterface.enqueue(result);
        return result;
    }

    private double getDouble(String integer) {
        int value = charToASCII.getValueASCII(integer);
        return charToASCII.returnDecimal(value);
    }

    private int getASCII(String element) {
        int elementValue = element.charAt(0);
        return elementValue;
    }

    //TODO Only public For testing
    public double getTotalSum() {
        return totalSum;
    }

}
