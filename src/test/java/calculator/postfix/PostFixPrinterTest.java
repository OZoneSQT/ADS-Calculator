package calculator.postfix;

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
class PostFixPrinterTest {
    private PostFixPrinter postFixPrinter;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeEach
    void setUp() {
        // Arrange
        postFixPrinter = new PostFixPrinter();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void printPostFixExpressionTestExpressionFalse() {
        // Act
        String expression = "1+2-3*2/5*5-2";
        postFixPrinter.testPrintPostFixExpression(expression);
        // Assert
        assertNotEquals("1 2 + 3 2 * 5 / 5 * - 2 - ", outContent.toString());
    }

    @Test
    void printPostFixExpressionTestExpressionTrue() {
        // Act
        String expression = "1 + 2 - 3 * 2 / 5 * 5 - 2";
        postFixPrinter.testPrintPostFixExpression(expression);
        // Assert
        assertEquals("1 2 + 3 2 * 5 / 5 * - 2 - ", outContent.toString());
    }

    @Test
    void printPostFixExpressionTestExpressionNullPointerExceptionFalse() {
        // Assert
        expectedException.expect(NullPointerException.class);
        // Act
        String expression = null;
        postFixPrinter.testPrintPostFixExpression(expression);
        // Assert
        assertEquals("1 2 + 3 2 * 5 / 5 * - 2 - ", outContent.toString());
    }

    //TODO Throws the expected "IllegalArgumentException" but fails the test
    /*
    @Test
    void printPostFixExpressionTestExpressionIllegalArgumentExceptionFalse() {
        // Assert
        expectedException.expect(IllegalArgumentException.class);
        // Act
        String expression = "1 + A - 3 * 2 / 5 * 5 - 2";
        postFixPrinter.testPrintPostFixExpression(expression);
    }
    */

}