package calculator.nodes;

public class NumericNode implements TreeNode {
  private int value;

  public NumericNode(int val) {
    value = val;
  }

  public int getValue(){
    return value;
  }

  public String getLabel(){
     return (new Integer(value)).toString();
  }

  public void accept(Visitor v) {
    v.visitNumericNode(this);
  }

}