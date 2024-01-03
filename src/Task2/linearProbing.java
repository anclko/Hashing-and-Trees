package Task2;

public class linearProbing {
    private int size;
    private int[] buckets;

    // Constructor to initialize the hash table with a specified size
    public linearProbing(int size) {
        this.size = size;
        buckets = new int[size];
    }

    // Hash function to compute the index for a given key
    private int hashFunction(int value) {
        return value % size;
    }

    // Method to insert a key into the hash table using linear probing
    public void linearProbingInsert(int key) {
        // Compute the initial index for the key
        int index = hashFunction(key);

        // If the slot at the computed index is occupied, keep moving to the next slot
        while (buckets[index] != 0) {
            // Linear probing: move to the next slot, wrap around if necessary
            index = (index + 1) % size;
        }
        // Place the key in the found empty slot
        buckets[index] = key;
    }

    // Method to rehash the hash table when needed
    public void rehash() {
        // Double the size of the hash table
        int newSize = size * 2;
        // Create a new array with the new size
        int[] newBuckets = new int[newSize];

        // Rehash all existing keys into the new array
        for (int item : buckets) {
            // Check if the slot is not empty
            if (item != 0) {
                // Compute new index for each key
                int index = item % newSize;

                // Ensure the slot at the new index is empty (linear probing)
                while (newBuckets[index] != 0) {
                    // Find the next empty slot
                    index = (index + 1) % newSize;
                }
                // Insert the key into the new slot
                newBuckets[index] = item;
            }
        }

        // Update the size of the hash table
        size = newSize;
        // Replace the old array with the new array
        buckets = newBuckets;
    }

    // Method to display the contents of the hash table
    public void display() {
        // Iterate through each slot in the hash table
        for (int i = 0; i < size; i++) {
            // Print the slot number
            System.out.print("Slot " + i + ": ");
            // If the slot is not empty
            if (buckets[i] != 0) {
                // Print the key stored in the slot
                System.out.print(buckets[i]);
            }
            System.out.println();
        }
    }
}
