import calculator.Calculator;
import calculator.io.Printer;
import calculator.nodes.Visitor;
import calculator.nodes.TreeNode;
import calculator.util.StackInterface;
import calculator.util.StackLIFO;

public class Main {

    public static void main(String[] args) {
        execute("1 + 2 * 4 - 3 * 4 / 5");
        // execute("4 * 2 + 4 - 3 / 41 + 5");
        // execute("4 * 2 * 4 - 3 / 41 + 5");
        // execute("1 / 2 * 4 - 3 * 4 / 5 + 2 * 4 - 3 * 4 / 5");
        // execute("4 / 5");
    }

    private static void execute(String expression) {
        StackInterface stackInterface = new StackLIFO();
        Calculator calculator = new Calculator(expression, stackInterface);
        TreeNode treeNode = calculator.compute();
        String string = expression + "   ->   ";
        output(treeNode, string, stackInterface);
    }

    private static void output(TreeNode treeNode, String string, StackInterface stackInterface) {
        System.out.print(string);
        Visitor visitor = new Printer();
        treeNode.acceptVisitor(visitor);
        System.out.print(" = " + stackInterface.dequeue());
        System.out.println();
    }

}
