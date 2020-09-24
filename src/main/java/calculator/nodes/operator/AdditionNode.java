package calculator.nodes.operator;

import calculator.nodes.TreeNode;

public class AdditionNode extends OperatorNode {

    public AdditionNode(TreeNode left, TreeNode right) {
        super(left, right);
    }

    public String getLabel(){
        return "+";
    }

    public double computeOperator(double a, double b){
        return a+b;
    }

}
