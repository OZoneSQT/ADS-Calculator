package calculator;

import calculator.infix.InFixCalculator;
import calculator.infix.InFixPrintVisitor;
import calculator.nodes.TreeNode;
import calculator.nodes.Visitor;

class ParserTest{
	public static void main(String[] args)  {
		InFixCalculator parser = new InFixCalculator("1 + 2 - 3 * 2 / 5 * 5 - 2 * -1"); // spaces are vital!!
	    TreeNode node = parser.parse();
	    System.out.print("INFIX: ");
	    Visitor v = new InFixPrintVisitor();
	    node.accept(v);
	    System.out.println();
	  }
}