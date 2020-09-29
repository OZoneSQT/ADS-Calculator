package calculator.nodes;

public class DivisionNode extends BinaryOperatorNode {

  public DivisionNode(TreeNode left, TreeNode right) {
    super(left,right);
  }

  public String getLabel(){
   return "/";
 }

  public int compute(int a, int b){
      int result = a/b;
      // System.out.println("a = " + a + ", b = " + b + ", = " + result);
    return result;
  }

}