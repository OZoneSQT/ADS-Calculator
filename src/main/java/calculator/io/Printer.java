package calculator.io;

import calculator.nodes.Visitor;
import calculator.nodes.numeric.NumericNode;
import calculator.nodes.operator.OperatorNode;

public class Printer extends Visitor {

    public void visitNumericNode(NumericNode numericNode) {
        System.out.print(numericNode.getLabel());
    }

    public void visitOperatorNode(OperatorNode operatorNode) {
        System.out.print("(");
        if (operatorNode.getLeft() != null)
            operatorNode.getLeft().acceptVisitor(this);

        System.out.print(" " + operatorNode.getLabel() + " ");

        if (operatorNode.getRight() != null)
            operatorNode.getRight().acceptVisitor(this);
        System.out.print(")");
    }

}
