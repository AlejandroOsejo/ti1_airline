public class Main {
    public static void main(String[] args) {
        BoardingSystem boardingSystem = new BoardingSystem("passangers.txt");

        System.out.println("Passangers:");
        boardingSystem.printPassengers();

        System.out.println("Passanger 1:");
        System.out.println(boardingSystem.getPassenger(1));
    }
}