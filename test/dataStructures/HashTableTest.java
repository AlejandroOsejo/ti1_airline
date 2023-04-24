package dataStructures;

import model.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    private HashTable<String, Passenger> hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable<>(5);
    }

    @Test
    void testPutElement() {
        // Arrange
        Passenger passenger = new Passenger("1", "Juan Perez", 25, 1, 'A', false, 0, false);

        // Act
        hashTable.put(passenger.getId(), passenger);

        // Assert
        assertEquals(passenger, hashTable.get(passenger.getId()));
    }

    @Test
    void testGetElement() {
        // Arrange
        Passenger passenger = new Passenger("1", "Juan Perez", 25, 1, 'A', false, 0, false);
        hashTable.put(passenger.getId(), passenger);

        // Act
        Passenger passengerFound = hashTable.get(passenger.getId());

        // Assert
        assertEquals(passenger, passengerFound);
    }

    @Test
    void testGetElementNotFound() {
        // Arrange
        Passenger passenger = new Passenger("1", "Juan Perez", 25, 1, 'A', false, 0, false);
        hashTable.put(passenger.getId(), passenger);

        // Act
        Passenger passengerFound = hashTable.get("2");

        // Assert
        assertNull(passengerFound);
    }

    @Test
    void testRemoveElement() {
        // Arrange
        Passenger passenger = new Passenger("1", "Juan Perez", 25, 1, 'A', false, 0, false);
        hashTable.put(passenger.getId(), passenger);

        // Act
        Passenger passengerRemoved = hashTable.remove(passenger.getId());

        // Assert
        assertEquals(passenger, passengerRemoved);
    }
}