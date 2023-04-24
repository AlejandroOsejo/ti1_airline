package dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxPriorityQueueTest {

    private MaxPriorityQueue<Integer, String> maxPriorityQueue;

    @BeforeEach
    void setUp() {
        maxPriorityQueue = new MaxPriorityQueue<>(3);
    }

    @Test
    void testMaxInsert() {
        // Act
        maxPriorityQueue.maxInsert(1, "A");
        maxPriorityQueue.maxInsert(2, "B");
        maxPriorityQueue.maxInsert(3, "C");

        // Assert
        assertEquals("C", maxPriorityQueue.extractMax());
        assertEquals("B", maxPriorityQueue.extractMax());
        assertEquals("A", maxPriorityQueue.extractMax());
    }

    @Test
    void testMaxInsertFull() {
        // Act
        maxPriorityQueue.maxInsert(1, "A");
        maxPriorityQueue.maxInsert(2, "B");
        maxPriorityQueue.maxInsert(3, "C");

        // Assert
        assertThrows(RuntimeException.class, () -> maxPriorityQueue.maxInsert(4, "D"));
    }

    @Test
    void testExtractMax() {
        // Act
        maxPriorityQueue.maxInsert(1, "A");
        maxPriorityQueue.maxInsert(2, "B");
        maxPriorityQueue.maxInsert(3, "C");

        // Assert
        assertEquals("C", maxPriorityQueue.extractMax());
    }

    @Test
    void testExtractMaxEmpty() {
        // Assert
        assertThrows(RuntimeException.class, () -> maxPriorityQueue.extractMax());
    }

}