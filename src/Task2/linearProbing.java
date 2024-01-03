package Task2;

public class linearProbing {
    private int size;
    private int[] buckets;

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
            // move to the next slot if the current slot is occupied
            index = (index + 1) % size;
        }
        buckets[index] = key;
    }

    public void rehash() {
        int newSize = size * 2;
        int[] newBuckets = new int[newSize];

        for (int item : buckets) {
            if (item != 0) {
                int index = item % newSize;
                while (newBuckets[index] != 0) {
                    index = (index + 1) % newSize;
                }
                newBuckets[index] = item;
            }
        }

        size = newSize;
        buckets = newBuckets;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Slot " + i + ": ");
            if (buckets[i] != 0) {
                System.out.print(buckets[i]);
            }
            System.out.println();
        }
    }
}
