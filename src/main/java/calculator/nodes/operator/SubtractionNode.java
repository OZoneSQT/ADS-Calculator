package calculator.nodes.operator;

import calculator.nodes.BinaryOperatorNode;
import calculator.nodes.TreeNode;

public class SubtractionNode extends BinaryOperatorNode {

  public SubtractionNode(TreeNode left, TreeNode right) {
    super(left,right);
  }

  public String getLabel(){
   return "-";
 }

  public int compute(int a, int b){
      int result = a-b;
      // System.out.println("a = " + a + ", b = " + b + ", = " + result);
    return result;
  }

}