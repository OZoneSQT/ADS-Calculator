package calculator.infix;

import calculator.nodes.TreeNode;
import calculator.nodes.Visitor;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@EnableRuleMigrationSupport
class InFixCalculatorTest {
    private InFixCalculator inFixCalculator;
    private TreeNode treeNode;
    private Visitor visitor;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeEach
    void setUp() {
        // Arrange

        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    //TODO Test crashes: Process finished with exit code 1, but throws IllegalArgumentException
    /*
    @Test
    void inPostFixExpressionTestExpressionIllegalArgumentExceptionFalse() {
        // Assert
        expectedException.expect(IllegalArgumentException.class);
        // Act
        String expression = "1+ 2 - 3 * 2 / 5 * 5 - 2";
        inFixCalculator = new InFixCalculator(expression);
        treeNode = inFixCalculator.parse();
        visitor = new InFixPrintVisitor();
        treeNode.accept(visitor);
    }
    */

    //TODO Test crashes: Process finished with exit code 1, but throws IllegalArgumentException
    /*
    @Test
    void inPostFixExpressionTestExpressionIllegalArgumentExceptionLetterFalse() {
        // Assert
        expectedException.expect(IllegalArgumentException.class);
        // Act
        String expression = "1 + b - 3 * 2 / 5 * 5 - 2";
        inFixCalculator = new InFixCalculator(expression);
        treeNode = inFixCalculator.parse();
        visitor = new InFixPrintVisitor();
        treeNode.accept(visitor);
    }
    */

    @Test
    void inPostFixExpressionTestExpressionNullPointerExceptionFalse() {
        // Assert
        expectedException.expect(NullPointerException.class);
        // Act
        String expression = null;
        inFixCalculator = new InFixCalculator(expression);
        treeNode = inFixCalculator.parse();
        visitor = new InFixPrintVisitor();
        treeNode.accept(visitor);

    }

    @Test
    void inPostFixExpressionTestExpressionTrue() {
        // Act
        String expression = "1 + 2 - 3 * 2 / 5 * 5 - 2";
        inFixCalculator = new InFixCalculator(expression);
        treeNode = inFixCalculator.parse();
        visitor = new InFixPrintVisitor();
        treeNode.accept(visitor);
        // Assert
        assertEquals("(((1 + 2) - (((3 * 2) / 5) * 5)) - 2)", outContent.toString());
    }

}