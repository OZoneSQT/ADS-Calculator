package calculator.nodes;

public abstract class BinaryOperatorNode implements TreeNode {
  private TreeNode left, right;

  public BinaryOperatorNode(TreeNode left, TreeNode right) {
    this.left = left;
    this.right = right;
  }

  public TreeNode getLeft() {
    return this.left;
  }

  public TreeNode getRight()  {
    return this.right;
  }

  public abstract int compute(int a, int b);

  public void accept(Visitor v) {
    v.visitBinaryOperatorNode(this);
  }

}