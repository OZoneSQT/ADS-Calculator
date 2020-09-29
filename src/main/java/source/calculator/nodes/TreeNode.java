package source.calculator.nodes;

public interface TreeNode {

    /**
     * Get string value of integer
     * @return
     */
    String getLabel() ;

    /**
     * Compute a-value and b-value
     */
    double computeOperator(double a, double b);

    /**
     * Set calculators.visitor
     * @param visitor
     */
    void acceptVisitor(Visitor visitor);

}
