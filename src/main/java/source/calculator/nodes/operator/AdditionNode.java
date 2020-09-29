package source.calculator.nodes.operator;

import source.calculator.nodes.TreeNode;

public class AdditionNode extends OperatorNode {

    public AdditionNode(TreeNode left, TreeNode right) {
        super(left, right);
    }

    public String getLabel(){
        return "+";
    }

    public double computeOperator(double a, double b){
        System.out.println("a = " + a + ", b = " + b + ", result = " + a+b );
        return a+b;
    }

}
