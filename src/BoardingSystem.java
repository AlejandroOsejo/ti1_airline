import dataStructures.HashTable;
import dataStructures.Queue;

import java.io.*;

public class BoardingSystem {
    private HashTable<Integer, Passanger> passangers;
    private Queue<Integer> arrivalQueue;

    public BoardingSystem(String filename) {
        loadPassengers(filename);
        arrivalQueue = new Queue<>(passangers.size());
    }

    private void loadPassengers(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int numPassangers = Integer.parseInt(reader.readLine());
            passangers = new HashTable<>(numPassangers);
            while ((line = reader.readLine()) != null) {
                String[] infoPassanger = line.split(",");
                int id = Integer.parseInt(infoPassanger[0].trim());
                String name = infoPassanger[1].trim();
                int age = Integer.parseInt(infoPassanger[2].trim());
                boolean isFirstClass = Boolean.parseBoolean(infoPassanger[3].trim());
                int row = Integer.parseInt(infoPassanger[4].trim());
                char seat = infoPassanger[5].trim().charAt(0);
                boolean isSpecialAttention = Boolean.parseBoolean(infoPassanger[6].trim());
                Passanger passanger = new Passanger(id, name, age, isFirstClass, row, seat, isSpecialAttention);
                passangers.put(id, passanger);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPassenger(int id) {
        return passangers.get(id).toString();
    }

    public void printPassengers() {
        System.out.println(passangers.toString());
    }

    public void addPassangerToQueue(int id) {
        arrivalQueue.enqueue(id);
    }

    public void printArrivalQueue() {
        System.out.println(arrivalQueue.toString());
    }


}
