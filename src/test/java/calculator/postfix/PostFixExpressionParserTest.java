package calculator.postfix;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

@EnableRuleMigrationSupport
class PostFixExpressionParserTest {
    private PostFixExpressionParser postFixExpressionParser;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeEach
    void setUp() {
        // Arrange
        postFixExpressionParser = new PostFixExpressionParser();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isOperatorFalseNumber() {
        // Act
        // Assert
        assertFalse(postFixExpressionParser.isOperator("1"));
    }

    @Test
    void isOperatorFalseLetter() {
        // Act
        // Assert
        assertFalse(postFixExpressionParser.isOperator("A"));
    }

    @Test
    void isOperatorTrue() {
        // Act

        // Assert
        assertTrue(postFixExpressionParser.isOperator("+"));
        assertTrue(postFixExpressionParser.isOperator("-"));
        assertTrue(postFixExpressionParser.isOperator("*"));
        assertTrue(postFixExpressionParser.isOperator("/"));
    }

    @Test
    void isRightExpressionFalseIllegalArgumentException() {
        // Assert
        expectedException.expect(IllegalArgumentException.class);
        // Act
        postFixExpressionParser.isRightExpression("9", 0);
    }

    @Test
    void isRightExpressionFalseIllegalArgumentExceptionNull() {
        // Assert
        expectedException.expect(IllegalArgumentException.class);
        // Act
        postFixExpressionParser.isRightExpression(null, 0);
    }

    @Test
    void isRightExpressionTrue() {
        // Act

        // Assert
        assertTrue(postFixExpressionParser.isRightExpression("+", 0));
    }

    @Test
    void computeLeftExpressionFalseIllegalArgumentExceptionNull() {
        // Assert
        expectedException.expect(IllegalArgumentException.class);
        // Act
        postFixExpressionParser.computeLeftExpression(null, null);
    }

    @Test
    void computeLeftExpressionFalseIllegalArgumentExceptionOperator() {
        // Assert
        expectedException.expect(IllegalArgumentException.class);
        // Act
        postFixExpressionParser.computeLeftExpression("+", "1");
    }

    @Test
    void computeLeftExpressionFalseIllegalArgumentExceptionLetter() {
        // Assert
        expectedException.expect(IllegalArgumentException.class);
        // Act
        postFixExpressionParser.computeLeftExpression("D", "5");
    }

    @Test
    void computeLeftExpressionTrueA() {
        // Act

        // Assert
        assertEquals(-5, postFixExpressionParser.computeLeftExpression("+", "*"));
    }
    @Test
    void computeLeftExpressionTrueB() {
        // Act

        // Assert
        assertEquals(0, postFixExpressionParser.computeLeftExpression("+", "+"));
    }

    @Test
    void getLeftExpression() {
        // Act

        // Assert
        assertEquals(0, postFixExpressionParser.getLeftExpression());
    }

    @Test
    void getRightExpression() {
        // Act

        // Assert
        assertEquals(0, postFixExpressionParser.getLeftExpression());
    }

}