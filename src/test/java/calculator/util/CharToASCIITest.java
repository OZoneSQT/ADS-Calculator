package calculator.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import static org.junit.jupiter.api.Assertions.*;

@EnableRuleMigrationSupport
class CharToASCIITest {
    private CharToASCII charToASCII;
    
    @BeforeEach
    void setUp() {
        // Arrange
        charToASCII = new CharToASCII();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFalseValueASCII() {
        String condition = "2";
        // Act
        int result = charToASCII.getValueASCII(condition);
        // Assert
        assertNotEquals(48, result);
    }

    @Test
    void getTrueValueASCII() {
        String condition = "0";
        // Act
        int result = charToASCII.getValueASCII(condition);
        // Assert
        assertEquals(48, result);
    }

    @Test
    void returnFalseDecimal() {
        int condition = 57;
        // Act
        double result = charToASCII.returnDecimal(condition);
        // Assert
        assertNotEquals(0.0, result);
    }

    @Test
    void returnTrueFalseDecimal() {
        int condition = 58;
        // Act
        double result = charToASCII.returnDecimal(condition);
        // Assert
        assertEquals(999.0, result);
    }

    @Test
    void returnTrueDecimal() {
        int condition = 48;
        // Act
        double result = charToASCII.returnDecimal(condition);
        // Assert
        assertEquals(0.0, result);
    }

}