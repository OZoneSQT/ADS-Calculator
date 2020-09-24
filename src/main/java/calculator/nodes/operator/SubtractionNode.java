package calculator.nodes.operator;

import calculator.nodes.TreeNode;

public class SubtractionNode extends OperatorNode {

    public SubtractionNode(TreeNode left, TreeNode right) {
        super(left, right);
    }

    public String getLabel(){
        return "-";
    }

    //Apply this operator (-) to the given operands
    public double computeOperator(double a, double b){
        return a-b;
    }
}
