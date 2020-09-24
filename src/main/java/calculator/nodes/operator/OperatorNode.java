package calculator.nodes.operator;

import calculator.nodes.Visitor;
import calculator.nodes.TreeNode;

public abstract class OperatorNode implements TreeNode {
    private TreeNode left, right;

    public OperatorNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public abstract double computeOperator(double a, double b);

    public void acceptVisitor(Visitor visitor) {
        visitor.visitOperatorNode(this);
    }

}
