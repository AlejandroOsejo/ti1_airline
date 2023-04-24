package dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>(3);
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

        // Assert
        assertThrows(IndexOutOfBoundsException.class, () -> queue.enqueue("D"));
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

}