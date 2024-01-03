package Task2;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        separateChaining separateChainingTable = new separateChaining(10);
        linearProbing linearProbingTable = new linearProbing(10);
        quadraticProbing quadraticProbingTable = new quadraticProbing(10);

        int[] data = { 4371, 1323, 6173, 4199, 4344, 9679, 1989 };

        // Separate Chaining
        System.out.println("Separate Chaining:");
        for (int item : data) {
            separateChainingTable.separateChainingInsert(item);
        }
        separateChainingTable.display();
        System.out.println();

        // Linear Probing
        System.out.println("Linear Probing:");
        for (int item : data) {
            linearProbingTable.linearProbingInsert(item);
        }
        linearProbingTable.display();

        // Quadratic Probing
        System.out.println("\nQuadratic Probing:");
        for (int item : data) {
            quadraticProbingTable.quadraticProbingInsert(item);
        }
        quadraticProbingTable.display();

        // Rehashing
        System.out.println("\nRehashing:");
        System.out.println("Separate Chaining Rehash:");
        separateChainingTable.rehash();
        separateChainingTable.display();

        System.out.println("\nLinear Probing Rehash:");
        linearProbingTable.rehash();
        linearProbingTable.display();
        System.out.println();

        System.out.println("\nQuadratic Probing Rehash:");
        quadraticProbingTable.rehash();
        quadraticProbingTable.display();
        System.out.println();
    }
}