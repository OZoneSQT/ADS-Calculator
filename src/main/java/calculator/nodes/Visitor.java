package calculator.nodes;

import calculator.nodes.operator.OperatorNode;
import calculator.nodes.numeric.NumericNode;

public abstract class Visitor {
    public abstract void visitNumericNode(NumericNode node);
    public abstract void visitOperatorNode(OperatorNode operatorNode);

}
