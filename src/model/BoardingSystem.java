package model;

import dataStructures.HashTable;
import dataStructures.MaxPriorityQueue;
import dataStructures.MinPriorityQueue;
import dataStructures.Queue;

import java.io.*;
import java.util.ArrayList;

public class BoardingSystem {
    private HashTable<String, Passenger> passengers;
    private Queue<String> arrivalQueue;
    private MaxPriorityQueue<Integer, String> boardingQueue;
    private MinPriorityQueue<Integer, String> exitQueue;
    private int rows;
    private int columns;

    public BoardingSystem() {

    }

    public void loadPassengers(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            this.rows = Integer.parseInt(reader.readLine());
            this.columns = Integer.parseInt(reader.readLine());
            int numPassengers = Integer.parseInt(reader.readLine());
            passengers = new HashTable<>(numPassengers);
            while ((line = reader.readLine()) != null) {
                String[] infoPassenger = line.split(",");
                String id = infoPassenger[0].trim();
                String name = infoPassenger[1].trim();
                int age = Integer.parseInt(infoPassenger[2].trim());
                int row = Integer.parseInt(infoPassenger[3].trim());
                char seat = infoPassenger[4].trim().charAt(0);
                boolean isFirstClass = Boolean.parseBoolean(infoPassenger[5].trim());
                int accumulatedMiles = Integer.parseInt(infoPassenger[6].trim());
                boolean isSpecialAttention = Boolean.parseBoolean(infoPassenger[7].trim());
                Passenger passenger = new Passenger(id, name, age, row, seat, isFirstClass, accumulatedMiles, isSpecialAttention);
                passengers.put(id, passenger);

                arrivalQueue = new Queue<>(passengers.size());
                boardingQueue = new MaxPriorityQueue<>(passengers.size());
                exitQueue = new MinPriorityQueue<>(passengers.size());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Passenger getPassenger(String id) {
        return passengers.get(id);
    }


    public void addToArrivalQueue(String id) {
        arrivalQueue.enqueue(id);
    }

    public void addToArrivalQueueTest(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String id = line.trim();
                arrivalQueue.enqueue(id);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPriorityEntrance() {
        Queue<String> tempQueue = arrivalQueue;
        while (!tempQueue.isEmpty()) {
            int arrivalNum = tempQueue.size();
            String id = tempQueue.dequeue();
            Passenger passenger = passengers.get(id);
            passenger.setPriorityEntrance(arrivalNum, rows);
            boardingQueue.maxInsert(passenger.getPriority(), id);
        }
    }

    private int determineProximity(char seat) {
        int proximity = 0;
        String seats = "ABCDEFGHIJ".substring(0, columns);
        int temp = (this.columns / 2) - 1;
        int temp2 = temp + 1;
        while (temp > 0 && temp2 < this.columns) {
            if (seats.charAt(temp) == seat || seats.charAt(temp2) == seat) {
                break;
            } else {
                proximity++;
                temp--;
                temp2++;
            }
        }

        return proximity;
    }

    public void setPriorityExit() {
        Queue<String> tempQueue = arrivalQueue;
        int arrivalNum = 0;
        while (!tempQueue.isEmpty() && arrivalNum < passengers.size()) {
            arrivalNum++;
            String id = tempQueue.dequeue();
            Passenger passenger = passengers.get(id);
            int proximity = determineProximity(passenger.getSeat());
            passenger.setPriorityExit(arrivalNum, proximity);
            exitQueue.minInsert(passenger.getPriority(), id);
        }
    }

    public ArrayList<Passenger> getBoardingQueue() {
        ArrayList<Passenger> boardingOrder = new ArrayList<>();
        while (!boardingQueue.isEmpty()) {
            String id = boardingQueue.extractMax();
            Passenger passenger = passengers.get(id);
            boardingOrder.add(passenger);
        }
        return boardingOrder;
    }

    public ArrayList<Passenger> getExitQueue() {
        ArrayList<Passenger> exitOrder = new ArrayList<>();
        while (!exitQueue.isEmpty()) {
            String id = exitQueue.extractMin();
            Passenger passenger = passengers.get(id);
            exitOrder.add(passenger);
        }
        return exitOrder;
    }

    public void printPassengers() {
        System.out.println(passengers.toString());
    }

    public void printArrivalQueue() {
        System.out.println(arrivalQueue.toString());
    }

    public void printBoardingQueue() {
        System.out.println(boardingQueue.toString());
    }

    public void printExitQueue() {
        System.out.println(exitQueue.toString());
    }
}
