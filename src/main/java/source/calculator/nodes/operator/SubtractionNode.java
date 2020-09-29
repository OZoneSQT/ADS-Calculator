package source.calculator.nodes.operator;

import source.calculator.nodes.TreeNode;

public class SubtractionNode extends OperatorNode {

    public SubtractionNode(TreeNode left, TreeNode right) {
        super(left, right);
    }

    public String getLabel(){
        return "-";
    }

    //Apply this operator (-) to the given operands
    public double computeOperator(double a, double b){
        System.out.println("a = " + a + ", b = " + b + ", operator = -");
        return a-b;
    }
}
