package calculator;

import calculator.infix.InFixCalculator;
import calculator.infix.InFixPrintVisitor;
import calculator.nodes.TreeNode;
import calculator.nodes.Visitor;
import calculator.postfix.PostFixPrinter;

public class Main {

    public static void main(String[] args) {
        String testExpression = "";

        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                testExpression = "1 + 2 - 3 * 2 / 5 * 5 - 2"; // spaces are vital!!
            } else if (i == 1) {
                testExpression = "9 * 2 / 5 + 5 - 2";
            } else if (i == 2) {
                testExpression = "1 - 2 * 3 / -2";
            } else if (i == 3) {
                testExpression = "22 + 2 * 2 / 6";
            } else if (i == 4) {
                testExpression = "32 - 5 / 5 * 6 - 6 / 2";
            } else {
                System.exit(0);
            }
            printExpression(testExpression);
        }

    }

    private static void printExpression(String expression) {
        System.out.print("ORIGINAL: ");
        System.out.println(expression);
        printInfix(expression);
        printPostFix(expression);
        System.out.println();
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
