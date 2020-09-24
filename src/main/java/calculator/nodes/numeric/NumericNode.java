package calculator.nodes.numeric;

import calculator.nodes.Visitor;
import calculator.nodes.TreeNode;

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
