package calculator.nodes.operator;

import calculator.nodes.TreeNode;

public class MultiplicationNode extends OperatorNode {

    public MultiplicationNode(TreeNode left, TreeNode right) {
        super( left, right);
    }

    public String getLabel(){
        return "*";
    }

    public double computeOperator(double a, double b) {
        return 0;
    }

}
