package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardingSystemTest {
    private BoardingSystem boardingSystem;

    @BeforeEach
    void setUp() {
        boardingSystem = new BoardingSystem();
    }

    @Test
    void testLoadPassengers() {
        boardingSystem.loadPassengers("resources/passengers.txt");
        assertEquals(20, boardingSystem.getPassengers().size());
    }

    @Test
    void testGetPassenger() {
        // Passenger 9,Ryan Howard,28,3,D,true,500,false
        boardingSystem.loadPassengers("resources/passengers.txt");
        Passenger passenger = boardingSystem.getPassenger("9");
        assertEquals("9", passenger.getId());
        assertEquals("Ryan Howard", passenger.getName());
        assertEquals(28, passenger.getAge());
        assertEquals(3, passenger.getRow());
        assertEquals('D', passenger.getSeat());
        assertTrue(passenger.isFirstClass());
        assertEquals(500, passenger.getAccumulatedMiles());
        assertFalse(passenger.isSpecialAttention());
    }

    @Test
    void testAddToArrivalQueue() {
        boardingSystem.loadPassengers("resources/passengers.txt");
        boardingSystem.addToArrivalQueue("9");
        assertEquals("9", boardingSystem.getArrivalQueue().peek());
    }

    @Test
    void testAddToBoardingQueue() {
        boardingSystem.loadPassengers("resources/passengers.txt");
        boardingSystem.addToArrivalQueue("9");
        boardingSystem.setPriorityEntrance();
        assertEquals("[9, Ryan Howard, 28, 3, D, true, 500, false]", boardingSystem.getBoardingQueue().toString());
    }

    @Test
    void testAddToExitQueue() {
        boardingSystem.loadPassengers("resources/passengers.txt");
        boardingSystem.addToArrivalQueue("9");
        boardingSystem.setPriorityExit();
        assertEquals("[9, Ryan Howard, 28, 3, D, true, 500, false]", boardingSystem.getExitQueue().toString());
    }

}