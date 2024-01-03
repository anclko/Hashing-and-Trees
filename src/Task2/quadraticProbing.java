package Task2;

public class quadraticProbing {
    private int size;
    private int[] buckets;

    // Constructor
    public quadraticProbing(int size) {
        this.size = size;
        buckets = new int[size];
    }

    private int hashFunction(int value) {
        return value % size;
    }

    public void quadraticProbingInsert(int key) {
        int index = hashFunction(key);
        int i = 0;
        while (buckets[index] != 0) {
            i++;
            index = (index + i * i) % size;
        }
        buckets[index] = key;
    }

    public void rehash() {
        int newSize = size * 2;
        int[] newBuckets = new int[newSize];

        for (int item : buckets) {
            if (item != 0) {
                int index = item % newSize;
                int i = 0;
                while (newBuckets[index] != 0) {
                    i++;
                    index = (index + i * i) % newSize;
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
