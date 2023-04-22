package ui;

import model.BoardingSystem;

public class Main {
    public static void main(String[] args) {
        BoardingSystem boardingSystem = new BoardingSystem("passangers.txt");

        System.out.println("Passangers:");
        boardingSystem.printPassengers();

        System.out.println("Passanger 1:");
        System.out.println(boardingSystem.getPassenger("1"));

        boardingSystem.addToArrivalQueue("1");
        boardingSystem.addToArrivalQueue("2");
        boardingSystem.addToArrivalQueue("3");
        boardingSystem.addToArrivalQueue("4");

        System.out.println("\nArrival queue:");
        boardingSystem.printArrivalQueue();

        boardingSystem.setPriorityEntrance();

        System.out.println("\nBoarding queue:");
        boardingSystem.printBoardingQueue();

    }
}