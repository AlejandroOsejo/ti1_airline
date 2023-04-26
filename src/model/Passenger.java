package model;

public class Passenger {
    private String id;
    private String name;
    private int age;
    private int row;
    private char seat;
    private int accumulatedMiles;
    private boolean isFirstClass;
    private boolean isSpecialAttention;
    private PriorityEntrance priorityEntrance;
    private PriorityExit priorityExit;

    public Passenger(String id, String name, int age, int row, char seat, boolean isFirstClass, int accumulatedMiles, boolean isSpecialAttention) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.row = row;
        this.seat = seat;
        this.isFirstClass = isFirstClass;
        this.accumulatedMiles = accumulatedMiles;
        this.isSpecialAttention = isSpecialAttention;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isFirstClass() {
        return isFirstClass;
    }

    public int getRow() {
        return row;
    }

    public char getSeat() {
        return seat;
    }

    public int getAccumulatedMiles() {
        return accumulatedMiles;
    }

    public boolean isSpecialAttention() {
        return isSpecialAttention;
    }

    public PriorityEntrance getPriorityEntrance() {
        return priorityEntrance;
    }

    public void setPriorityEntrance(int arrivalNum) {
        this.priorityEntrance = new PriorityEntrance(age, row, arrivalNum, accumulatedMiles, isFirstClass, isSpecialAttention);
    }

    public PriorityExit getPriorityExit() {
        return priorityExit;
    }

    public void setPriorityExit(int arrivalNum, int proximity) {
        this.priorityExit = new PriorityExit(row, proximity, arrivalNum);
    }

    public String toString() {
        return id + ", " + name + ", " + age + ", " + row + ", " + seat + ", " + isFirstClass + ", " + accumulatedMiles + ", " + isSpecialAttention;
    }
}
