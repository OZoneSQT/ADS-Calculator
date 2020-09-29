package source.calculator.nodes.numeric;

import source.calculator.nodes.Visitor;
import source.calculator.nodes.TreeNode;

public class NumericNode implements TreeNode {

    private int value;

    public NumericNode(int value) {
        this.value = value;
    }

    public String getLabel() {
        return (new Integer(value)).toString();
    }

    public double computeOperator(double a, double b) {
        return 0;
    }

    public void acceptVisitor(Visitor visitor) {
        visitor.visitNumericNode(this);
    }
}
