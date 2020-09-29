package source.calculator.nodes;

import source.calculator.nodes.operator.OperatorNode;
import source.calculator.nodes.numeric.NumericNode;

public abstract class Visitor {
    public abstract void visitNumericNode(NumericNode node);
    public abstract void visitOperatorNode(OperatorNode operatorNode);

}
