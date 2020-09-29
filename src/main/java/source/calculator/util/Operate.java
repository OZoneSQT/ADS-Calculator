package source.calculator.util;

import source.calculator.nodes.TreeNode;
import source.calculator.nodes.operator.AdditionNode;
import source.calculator.nodes.operator.DivisionNode;
import source.calculator.nodes.operator.MultiplicationNode;
import source.calculator.nodes.operator.SubtractionNode;

public class Operate {
    private QueueInterface queueInterface;
    private StackInterface stackInterface;
    private ValueParser valueParser;
    private double totalSum;

    public Operate(String expression, StackInterface stackInterface) {
        this.totalSum = 0;
        queueInterface = new QueueFIFO(expression.length());
        this.stackInterface = stackInterface;
        valueParser = new ValueParser();
    }

    public TreeNode addition(TreeNode rightExpression, TreeNode leftExpression) {
        TreeNode treeNode = new AdditionNode(leftExpression, rightExpression);
        totalSum = computeOperator(treeNode, leftExpression);
        // System.out.println("rightExpression = " + rightExpression + ", leftExpression = " + leftExpression + "total sum = " + totalSum);
        return treeNode;
    }

    public TreeNode subtraction(TreeNode leftExpression, TreeNode rightExpression) {
        TreeNode treeNode = new SubtractionNode(leftExpression, rightExpression);
        totalSum = computeOperator(treeNode, leftExpression);
        // System.out.println("rightExpression = " + rightExpression + ", leftExpression = " + leftExpression + "total sum = " + totalSum);
        return treeNode;
    }

    public TreeNode multiplication(TreeNode leftExpression, TreeNode rightExpression) {
        TreeNode treeNode = new MultiplicationNode(leftExpression, rightExpression);
        totalSum = computeOperator(treeNode, leftExpression);
        // System.out.println("rightExpression = " + rightExpression + ", leftExpression = " + leftExpression + "total sum = " + totalSum);
        return treeNode;
    }

    public TreeNode division(TreeNode leftExpression, TreeNode rightExpression) {
        TreeNode treeNode = new DivisionNode(leftExpression, rightExpression);
        totalSum = computeOperator(treeNode, leftExpression);
        // System.out.println("rightExpression = " + rightExpression + ", leftExpression = " + leftExpression + "total sum = " + totalSum);
        return treeNode;
    }

    private double computeOperator(TreeNode treeNode, TreeNode leftExpression) {
        double result = 0.0;
        if (queueInterface.isEmpty()) {
            queueInterface.enqueue(valueParser.getDoubleValue(leftExpression.toString()));
        } else {
            result = treeNode.computeOperator(valueParser.getDoubleValue(leftExpression.toString()), (double) queueInterface.dequeue());
        }
        stackInterface.enqueue(result);
        return result;
    }

    //TODO Only public For testing
    public double getTotalSum() {
        return totalSum;
    }

}
