package dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinPriorityQueueTest {

    private MinPriorityQueue<Integer, String> minPriorityQueue;

    @BeforeEach
    void setUp() {
        minPriorityQueue = new MinPriorityQueue<>(3);
    }

    @Test
    void testMinInsert() {
        // Act
        minPriorityQueue.minInsert(3, "C");
        minPriorityQueue.minInsert(2, "B");
        minPriorityQueue.minInsert(1, "A");

        // Assert
        assertEquals("A", minPriorityQueue.extractMin());
        assertEquals("B", minPriorityQueue.extractMin());
        assertEquals("C", minPriorityQueue.extractMin());
    }

    @Test
    void testMinInsertFull() {
        // Act
        minPriorityQueue.minInsert(3, "C");
        minPriorityQueue.minInsert(2, "B");
        minPriorityQueue.minInsert(1, "A");

        // Assert
        assertThrows(RuntimeException.class, () -> minPriorityQueue.minInsert(4, "D"));
    }

    @Test
    void testExtractMin() {
        // Act
        minPriorityQueue.minInsert(3, "C");
        minPriorityQueue.minInsert(2, "B");
        minPriorityQueue.minInsert(1, "A");

        // Assert
        assertEquals("A", minPriorityQueue.extractMin());
    }

    @Test
    void testExtractMinEmpty() {
        // Assert
        assertThrows(RuntimeException.class, () -> minPriorityQueue.extractMin());
    }

}