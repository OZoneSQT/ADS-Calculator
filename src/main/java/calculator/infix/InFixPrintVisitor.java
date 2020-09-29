package calculator.infix;

import calculator.nodes.BinaryOperatorNode;
import calculator.nodes.NumericNode;
import calculator.nodes.Visitor;

public class InFixPrintVisitor extends Visitor {

  public void visitBinaryOperatorNode(BinaryOperatorNode node)  {
    System.out.print("(");
    if (node.getLeft() != null)
      node.getLeft().accept(this);
    System.out.print(" " + node.getLabel() + " ");
    if (node.getRight() != null)
      node.getRight().accept(this);
    System.out.print(")");
  }

  public void visitNumericNode(NumericNode node)  {
    System.out.print(node.getLabel());
  }
}