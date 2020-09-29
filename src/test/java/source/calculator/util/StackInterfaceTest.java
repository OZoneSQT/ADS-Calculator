package source.calculator.util;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

@EnableRuleMigrationSupport
class StackInterfaceTest {
    private StackInterface<String> queueInterface;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeEach
    void setUp() {
        // Arrange
        queueInterface = new StackLIFO<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void queueIsEmptyTrue(){
        // Assert
        assertTrue(queueInterface.isEmpty());
    }

    @Test
    void queueIsEmptyFalse(){
        // Act
        queueInterface.enqueue("Alpha");
        // Assert
        assertFalse(queueInterface.isEmpty());
    }

    @Test
    void enqueueOne() {
        // Act
        queueInterface.enqueue("Alpha");
        // Assert
        assertEquals(1, queueInterface.size());
    }

    @Test
    void enqueueMore() {
        // Act
        queueInterface.enqueue("Alpha");
        queueInterface.enqueue("Beta");
        queueInterface.enqueue("Charlie");
        queueInterface.enqueue("Delta");
        queueInterface.enqueue("Echo");
        // Assert
        assertEquals(5, queueInterface.size());
    }

    @Test
    void enqueueIllegalArgumentException() {
        // Assert
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null is not allowed");
        // Act
        queueInterface.enqueue(null);
    }

    @Test
    void dequeueZeroIllegalStateException() {
        // Assert
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Queue is empty");
        // Act
        queueInterface.dequeue();
    }

    @Test
    void dequeueOne() {
        // Act
        queueInterface.enqueue("Alpha");
        queueInterface.enqueue("Beta");
        // Assert - First in, first out
        assertEquals("Beta", queueInterface.dequeue());
    }

    @Test
    void dequeueMore() {
        // Act
        queueInterface.enqueue("Alpha");
        queueInterface.enqueue("Beta");
        queueInterface.enqueue("Charlie");
        queueInterface.enqueue("Delta");
        queueInterface.enqueue("Echo");

        // Assert - Last in, first out
        assertEquals("Echo", queueInterface.dequeue());
        assertEquals("Delta", queueInterface.dequeue());
        assertEquals("Charlie", queueInterface.dequeue());
        assertEquals("Beta", queueInterface.dequeue());
        assertEquals("Alpha", queueInterface.dequeue());
    }

    @Test
    void sizeZeroTrue() {
        // Act

        // Assert
        assertEquals(0, queueInterface.size());
    }

    @Test
    void sizeZeroFalse() {
        // Act
        queueInterface.enqueue("Alpha");
        // Assert
        assertFalse(equals(0 == queueInterface.size()));
    }

    @Test
    void sizeOne() {
        // Act
        queueInterface.enqueue("Alpha");
        // Assert
        assertEquals(1, queueInterface.size());
    }

    @Test
    void isEmptyTrue() {
        // Act

        // Assert
        assertTrue(queueInterface.isEmpty() == true);
    }

    @Test
    void isEmptyFalse() {
        // Act
        queueInterface.enqueue("Alpha");
        // Assert
        assertTrue(queueInterface.isEmpty() == false);
    }

}