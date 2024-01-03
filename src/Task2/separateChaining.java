package Task2;

import java.util.LinkedList;

public class separateChaining {
    private int size;
    private LinkedList<Integer>[] buckets;

    // Constructor to initialize the hash table with a specified size
    public separateChaining(int size) {
        this.size = size;
        this.buckets = new LinkedList[size];

        // Initialize each LinkedList in the array
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function to compute the index for a given key
    private int hashFunction(int value) {
        return value % size;
    }

    // Method to insert a key into the hash table using separate chaining
    public void separateChainingInsert(int value) {
        // Compute the index for the key
        int index = hashFunction(value);
        // Add the key to the LinkedList at the computed index
        buckets[index].add(value);
    }

    // Method to rehash the hash table when needed
    public void rehash() {
        // Double the size of the hash table
        int newSize = size * 2;
        // Create a new array of LinkedLists with the new size
        LinkedList<Integer>[] newBuckets = new LinkedList[newSize];

        // Rehash all existing keys into the new array
        for (LinkedList<Integer> bucket : buckets) {
            for (int item : bucket) {
                // Compute new index for each key
                int index = item % newSize;
                if (newBuckets[index] == null) {
                    // Initialize the LinkedList if not already done
                    newBuckets[index] = new LinkedList<>();
                }
                // Add the item to the LinkedList at the new index
                newBuckets[index].add(item);
            }
        }
        // Update the size of the hash table
        size = newSize;
        // Replace the old array of LinkedLists with the new array
        buckets = newBuckets;
    }

    // Method to display the contents of the hash table
    public void display() {
        // Iterate through each slot in the hash table
        for (int i = 0; i < size; i++) {
            LinkedList<Integer> bucket = buckets[i];
            // Print the slot number
            System.out.print("Slot " + i + ": ");
            // Check if the bucket is not empty
            if (bucket != null && !bucket.isEmpty()) {
                // Iterate through each key in the bucket
                for (int item : bucket) {
                    System.out.print(item + " ");
                }
            }
            System.out.println();
        }
    }
}
