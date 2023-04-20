public class Passanger implements Comparable<Passanger> {
    private int id;
    private String name;
    private int age;
    private boolean isFirstClass;
    private int row;
    private char seat;
    private int priority;
    private boolean inBoardingRoom;

    public Passanger(int id, String name, int age, boolean isFirstClass, int row, char seat) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isFirstClass = isFirstClass;
        this.row = row;
        this.seat = seat;
        this.inBoardingRoom = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isInBoardingRoom() {
        return inBoardingRoom;
    }

    public void setInBoardingRoom(boolean inBoardingRoom) {
        this.inBoardingRoom = inBoardingRoom;
    }

    public String toString() {
        return id + ", " + name + ", " + age + ", " + isFirstClass + ", " + row + ", " + seat + ", " + priority;
    }

    @Override
    public int compareTo(Passanger o) {
        return this.priority - o.priority;
    }
}
