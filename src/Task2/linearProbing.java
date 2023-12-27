package Task2;

public class linearProbing {
    private final int size;
    private final int[] buckets;

    // Constructor
    public linearProbing(int size) {
        this.size = size;
        buckets = new int[size];
    }

    private int hashFunction(int value) {
        return value % size;
    }

    public void linearProbingInsert(int key) {
        int index = hashFunction(key);
        while (buckets[index] != 0) {
            //move to the next slot if the current slot is occupied
            index = (index + 1) % size;
        }
        buckets[index] = key;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": " + buckets[i] + " -> null\n");
        }
    }
}
