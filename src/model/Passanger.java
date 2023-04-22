package model;

public class Passanger {
    private String id;
    private String name;
    private int age;
    private int row;
    private char seat;
    private int accumulatedMiles;
    private boolean isFirstClass;
    private boolean isSpecialAttention;
    private boolean isThirdAge;
    private int priority;

    public Passanger(String id, String name, int age, int row, char seat, boolean isFirstClass, int accumulatedMiles, boolean isSpecialAttention) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.row = row;
        this.seat = seat;
        this.isFirstClass = isFirstClass;
        this.accumulatedMiles = accumulatedMiles;
        this.isSpecialAttention = isSpecialAttention;
        isThirdAge();
    }

    private void isThirdAge() {
        if (age >= 65) {
            this.isThirdAge = true;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFirstClass() {
        return isFirstClass;
    }

    public void setFirstClass(boolean firstClass) {
        isFirstClass = firstClass;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getSeat() {
        return seat;
    }

    public void setSeat(char seat) {
        this.seat = seat;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int arrivalNum, int lastRow) {
        if (this.isFirstClass) {
            this.priority = lastRow + 1 + arrivalNum;
            if (this.isSpecialAttention) {
                this.priority++;
            }
            if (this.isThirdAge) {
                this.priority++;
            }
            if (this.accumulatedMiles > 1000) {
                this.priority++;
            }
        } else {
            this.priority = row + arrivalNum;
        }
    }

    public String toString() {
        return id + ", " + name + ", " + age + ", " + row + ", " + seat + ", " + isFirstClass + ", " + accumulatedMiles + ", " + isSpecialAttention;
    }
}
