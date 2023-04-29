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
    void testPutTwoElements() {
        // Arrange
        Passenger passenger1 = new Passenger("1", "Juan Perez", 25, 1, 'A', false, 0, false);
        Passenger passenger2 = new Passenger("4", "Walter White", 50, 5, 'C', true, 10000, false);

        // Act
        hashTable.put(passenger1.getId(), passenger1);
        hashTable.put(passenger2.getId(), passenger2);

        // Assert
        assertEquals(passenger1, hashTable.get(passenger1.getId()));
        assertEquals(passenger2, hashTable.get(passenger2.getId()));
    }

    @Test
    void testPutThreeElements() {
        // Arrange
        Passenger passenger1 = new Passenger("1", "Juan Perez", 25, 1, 'A', false, 0, false);
        Passenger passenger2 = new Passenger("4", "Walter White", 50, 5, 'C', true, 10000, false);
        Passenger passenger3 = new Passenger("5", "Jesse Pinkman", 30, 2, 'B', true, 5000, false);

        // Act
        hashTable.put(passenger1.getId(), passenger1);
        hashTable.put(passenger2.getId(), passenger2);
        hashTable.put(passenger3.getId(), passenger3);

        // Assert
        assertEquals(passenger1, hashTable.get(passenger1.getId()));
        assertEquals(passenger2, hashTable.get(passenger2.getId()));
        assertEquals(passenger3, hashTable.get(passenger3.getId()));
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
    void testGetElementWithCollision() {
        // Arrange
        Passenger passenger1 = new Passenger("1", "Juan Perez", 25, 1, 'A', false, 0, false);
        Passenger passenger2 = new Passenger("4", "Walter White", 50, 5, 'C', true, 10000, false); // Collision with "1
        hashTable.put(passenger1.getId(), passenger1);
        hashTable.put(passenger2.getId(), passenger2);

        // Act
        Passenger passengerFound = hashTable.get(passenger2.getId());

        // Assert
        assertEquals(passenger2, passengerFound);
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

    @Test
    void testRemoveElementNotFound() {
        // Arrange
        Passenger passenger = new Passenger("1", "Juan Perez", 25, 1, 'A', false, 0, false);
        hashTable.put(passenger.getId(), passenger);

        // Act
        Passenger passengerRemoved = hashTable.remove("2");

        // Assert
        assertNull(passengerRemoved);
    }

    @Test
    void testRemoveElementWithCollision() {
        // Arrange
        Passenger passenger1 = new Passenger("1", "Juan Perez", 25, 1, 'A', false, 0, false);
        Passenger passenger2 = new Passenger("4", "Walter White", 50, 5, 'C', true, 10000, false); // Collision with "1
        hashTable.put(passenger1.getId(), passenger1);
        hashTable.put(passenger2.getId(), passenger2);

        // Act
        Passenger passengerRemoved = hashTable.remove(passenger2.getId());

        // Assert
        assertEquals(passenger2, passengerRemoved);
    }
}