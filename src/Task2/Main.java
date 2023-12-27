package Task2;

public class Main {
    public static void main(String[] args) {
        separateChaining separateChainingTable = new separateChaining(10);
        linearProbing linearProbing = new linearProbing(10);

        int[] data = {4371, 1323, 6173, 4199, 4344, 9679, 1989};

        //Seperate Chaining
        System.out.println("Separate Chaining:");
        for (int item : data) {
            separateChainingTable.separateChainingInsert(item);
        }
        separateChainingTable.display();
        System.out.println();

        //Linear Probing
        System.out.println("Linear Probing:");
        for (int item : data) {
            linearProbing.linearProbingInsert(item);
        }
        // Display the hash table
        linearProbing.display();
    }
}