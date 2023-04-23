package model;

import dataStructures.HashTable;
import dataStructures.MaxPriorityQueue;
import dataStructures.Queue;

import java.io.*;

public class BoardingSystem {
    private HashTable<String, Passenger> passengers;
    private Queue<String> arrivalQueue;
    private MaxPriorityQueue<Integer, String> boardingQueue;
    private int rows;

    public BoardingSystem() {

    }

    public void loadPassengers(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            this.rows = Integer.parseInt(reader.readLine());
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
                String id = reader.readLine();
                arrivalQueue.enqueue(id);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPriorityEntrance() {
        while (!arrivalQueue.isEmpty()) {
            int arrivalNum = arrivalQueue.size();
            String id = arrivalQueue.dequeue();
            Passenger passenger = passengers.get(id);
            passenger.setPriority(arrivalNum, rows);
            boardingQueue.maxInsert(passenger.getPriority(), id);
        }
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
}
