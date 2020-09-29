package calculator.nodes;

public interface TreeNode {

  public abstract String getLabel() ;

  public abstract void accept(Visitor v);

}