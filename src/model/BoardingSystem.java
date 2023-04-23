package model;

import dataStructures.HashTable;
import dataStructures.MaxPriorityQueue;
import dataStructures.Queue;

import java.io.*;

public class BoardingSystem {
    private HashTable<String, Passanger> passangers;
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
            int numPassangers = Integer.parseInt(reader.readLine());
            passangers = new HashTable<>(numPassangers);
            while ((line = reader.readLine()) != null) {
                String[] infoPassanger = line.split(",");
                String id = infoPassanger[0].trim();
                String name = infoPassanger[1].trim();
                int age = Integer.parseInt(infoPassanger[2].trim());
                int row = Integer.parseInt(infoPassanger[3].trim());
                char seat = infoPassanger[4].trim().charAt(0);
                boolean isFirstClass = Boolean.parseBoolean(infoPassanger[5].trim());
                int accumulatedMiles = Integer.parseInt(infoPassanger[6].trim());
                boolean isSpecialAttention = Boolean.parseBoolean(infoPassanger[7].trim());
                Passanger passanger = new Passanger(id, name, age, row, seat, isFirstClass, accumulatedMiles, isSpecialAttention);
                passangers.put(id, passanger);

                arrivalQueue = new Queue<>(passangers.size());
                boardingQueue = new MaxPriorityQueue<>(passangers.size());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPassenger(String id) {
        return passangers.get(id).toString();
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
            Passanger passanger = passangers.get(id);
            passanger.setPriority(arrivalNum, rows);
            boardingQueue.maxInsert(passanger.getPriority(), id);
        }
    }

    public void printPassengers() {
        System.out.println(passangers.toString());
    }

    public void printArrivalQueue() {
        System.out.println(arrivalQueue.toString());
    }

    public void printBoardingQueue() {
        System.out.println(boardingQueue.toString());
    }
}
