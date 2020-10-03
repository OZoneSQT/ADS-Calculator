package calculator;

import calculator.infix.InFixCalculator;
import calculator.infix.InFixPrintVisitor;
import calculator.nodes.TreeNode;
import calculator.nodes.Visitor;
import calculator.postfix.PostFixPrinter;

public class Main {

    public static void main(String[] args) {
        String testExpression = "1 + 2 - 3 * 2 / 5 * 5 - 2"; // spaces are vital!!
        printOriginalExpression(testExpression);
        printInfix(testExpression);
        printPostFix(testExpression);
    }

    private static void printOriginalExpression(String expression) {
        System.out.print("ORIGINAL: ");
        System.out.println(expression);
    }

    private static void printInfix(String expression) {
        InFixCalculator inFixCalculator = new InFixCalculator(expression);
        TreeNode treeNode = inFixCalculator.parse();
        System.out.print("INFIX: ");
        Visitor visitor = new InFixPrintVisitor();
        treeNode.accept(visitor);
        System.out.println();
    }

    private static void printPostFix(String expression) {
        System.out.print("POSTFIX: ");
        PostFixPrinter postFixPrinter = new PostFixPrinter();
        postFixPrinter.printPostFixExpression(expression);
    }

}
