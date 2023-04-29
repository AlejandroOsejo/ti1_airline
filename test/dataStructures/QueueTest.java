package dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>(5);
    }

    @Test
    void testEnqueue() {
        // Act
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        // Assert
        assertEquals("A B C", queue.toString());
    }

    @Test
    void testEnqueueFull() {
        // Act
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");

        // Assert
        assertThrows(IndexOutOfBoundsException.class, () -> queue.enqueue("F"));
    }

    @Test
    void testEnqueueTwo() {
        // Act
        queue.enqueue("A");
        queue.enqueue("B");

        // Assert
        assertEquals("A B", queue.toString());
    }

    @Test
    void testDequeue() {
        // Act
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        // Assert
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
    }

    @Test
    void testDequeueEmpty() {
        // Assert
        assertThrows(IndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Test
    void testDequeueAndEnqueue() {
        // Act
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.dequeue();
        queue.enqueue("D");

        // Assert
        assertEquals("B C D", queue.toString());
    }

    @Test
    void testPeek() {
        // Act
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        // Assert
        assertEquals("A", queue.peek());
        assertEquals("A B C", queue.toString());
    }

    @Test
    void testPeekEmpty() {
        // Assert
        assertThrows(IndexOutOfBoundsException.class, () -> queue.peek());
    }

    @Test
    void testPeekAndEnqueue() {
        // Act
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.peek();
        queue.enqueue("D");

        // Assert
        assertEquals("A B C D", queue.toString());
    }

}