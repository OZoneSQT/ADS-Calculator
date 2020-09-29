package source.calculator.util;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

@EnableRuleMigrationSupport
class QueueInterfaceTest {
    private QueueInterface<String> queueInterface;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeEach
    void setUp() {
        // Arrange
        queueInterface = new QueueFIFO<>(5);
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
        assertTrue(queueInterface.contains("Alpha"));
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
        assertTrue(queueInterface.contains("Alpha"));
        assertTrue(queueInterface.contains("Beta"));
        assertTrue(queueInterface.contains("Charlie"));
        assertTrue(queueInterface.contains("Delta"));
        assertTrue(queueInterface.contains("Echo"));
        assertEquals(5, queueInterface.size());
    }

    @Test
    void enqueueIllegalStateException() {
        // Assert
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Queue is full");
        // Act
        queueInterface.enqueue("Alpha");
        queueInterface.enqueue("Beta");
        queueInterface.enqueue("Charlie");
        queueInterface.enqueue("Delta");
        queueInterface.enqueue("Echo");
        queueInterface.enqueue("Golf");
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
        queueInterface.dequeue();
        // Assert - First in, first out
        assertFalse(queueInterface.contains("Alpha"));
        assertTrue(queueInterface.contains("Beta"));
        assertEquals(1, queueInterface.size());
    }

    @Test
    void dequeueMore() {
        // Act
        queueInterface.enqueue("Alpha");
        queueInterface.enqueue("Beta");
        queueInterface.enqueue("Charlie");
        queueInterface.enqueue("Delta");
        queueInterface.enqueue("Echo");

        for (int i = 0; i < 4 ; i++) {
            queueInterface.dequeue();
        }

        // Assert - First in, first out
        assertFalse(queueInterface.contains("Alpha"));
        assertFalse(queueInterface.contains("Beta"));
        assertFalse(queueInterface.contains("Charlie"));
        assertFalse(queueInterface.contains("Delta"));
        assertTrue(queueInterface.contains("Echo"));
        assertEquals(1, queueInterface.size());
    }

    @Test
    void first() {
        // Act
        queueInterface.enqueue("Alpha");
        // Assert
        assertTrue(queueInterface.dequeue() == "Alpha");
    }

    @Test
    void firstIllegalStateException() {
        // Assert
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Queue is empty");
        // Act
        queueInterface.first();
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

    @Test
    void indexOf() {
        // Act
        queueInterface.enqueue("Alpha");
        queueInterface.enqueue("Beta");
        // Assert
        assertFalse(queueInterface.indexOf("Beta") == 0);
        assertTrue(queueInterface.indexOf("Beta") == 1 );
        queueInterface.dequeue();
        assertTrue(queueInterface.indexOf("Beta") == 0 );
    }

    @Test
    void containsFull() {
        // Act
        queueInterface.enqueue("Alpha");
        queueInterface.enqueue("Beta");
        queueInterface.enqueue("Charlie");
        queueInterface.enqueue("Delta");
        queueInterface.enqueue("Echo");
        // Assert
        assertTrue(queueInterface.contains("Echo"));
        assertFalse(queueInterface.contains("Golf"));
    }

    @Test
    void containsMore() {
        // Act
        queueInterface.enqueue("Alpha");
        queueInterface.enqueue("Beta");
        queueInterface.enqueue("Charlie");
        queueInterface.enqueue("Delta");
        queueInterface.enqueue("Echo");
        // Assert
        assertTrue(queueInterface.contains("Alpha"));
        assertTrue(queueInterface.contains("Beta"));
        assertTrue(queueInterface.contains("Charlie"));
        assertTrue(queueInterface.contains("Delta"));
        assertTrue(queueInterface.contains("Echo"));
        assertFalse(queueInterface.contains("Golf"));
        // Act
        for (int i = 0; i < 5; i++) {
            queueInterface.dequeue();
        }
        queueInterface.enqueue("Golf");
        queueInterface.enqueue("Hotel");
        queueInterface.enqueue("India");
        queueInterface.enqueue("Juliett");
        queueInterface.enqueue("Kilo");
        // Assert
        assertTrue(queueInterface.contains("Golf"));
        assertTrue(queueInterface.contains("Hotel"));
        assertTrue(queueInterface.contains("India"));
        assertTrue(queueInterface.contains("Juliett"));
        assertTrue(queueInterface.contains("Kilo"));
        assertFalse(queueInterface.contains("Lima"));
    }

}