package source.calculator.util;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

@EnableRuleMigrationSupport
class ValueParserTest {
    ValueParser valueParser;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeEach
    void setUp() {
        // Arrange
        valueParser = new ValueParser();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTrueValueASCII() {
        // Act

        // Assert
        assertEquals(48, valueParser.getValueASCII("0"));
    }

    @Test
    void getFalseValueASCII() {
        // Act

        // Assert
        assertNotEquals(48, valueParser.getValueASCII("2"));
    }

    @Test
    void getTrueIntegerValue() {
        // Act

        // Assert
        assertEquals(1, valueParser.getIntegerValue("1"));
    }

    @Test
    void getFalseIntegerValue() {
        // Act

        // Assert
        assertEquals(1.0, valueParser.getIntegerValue("1"));
    }

    @Test
    void getTrueDoubleValue() {
        // Act

        // Assert
        assertEquals(1.0, valueParser.getDoubleValue("1"));
    }

    @Test
    void getFalseDoubleValue() {
        // Act

        // Assert
        assertNotEquals(1.0, valueParser.getDoubleValue("2"));
    }

    @Test
    void getNumberFormatExceptionDoubleValue() {
        // Assert
        expectedException.expect(NumberFormatException.class);
        // Act
        valueParser.getDoubleValue("+");
    }

    @Test
    void exceptionTesting() {
        NumberFormatException thrown = assertThrows(
                NumberFormatException.class,
                () -> valueParser.getDoubleValue(null),
                "ValueParser.getDoubleValue throws NumberFormatException"
        );

        assertTrue(thrown.getMessage().contains("ValueParser.getDoubleValue throws NumberFormatException"));
    }

    @Test
    void getNumberFormatExceptionDoubleValueNullInput() {
        // Assert
        expectedException.expect(NumberFormatException.class);
        // Act
        valueParser.getDoubleValue(null);
    }

    @Test
    void isIntegerTrueTrue() {
        // Act

        // Assert
        assertTrue(valueParser.isInteger("3"));
    }


    @Test
    void isIntegerNumberFormatException() {
        // Assert
        expectedException.expect(NumberFormatException.class);
        // Act
        valueParser.isInteger("b");
    }

    @Test
    void isIntegerNumberFormatExceptionNullInput() {
        // Assert
        expectedException.expect(NumberFormatException.class);
        // Act
        valueParser.isInteger(null);
    }

    @Test
    void isOperatorTrueAddition() {
        // Act

        // Assert
        assertTrue(valueParser.isOperator("+"));
    }

    @Test
    void isOperatorTrueSubtraction() {
        // Act

        // Assert
        assertTrue(valueParser.isOperator("-"));
    }

    @Test
    void isOperatorTrueMultiplication() {
        // Act

        // Assert
        assertTrue(valueParser.isOperator("*"));
    }

    @Test
    void isOperatorTrueDivision() {
        // Act

        // Assert
        assertTrue(valueParser.isOperator("/"));
    }

    @Test
    void isOperatorFalse() {
        // Act

        // Assert
        assertFalse(valueParser.isOperator("3"));
    }

}