package Task2;

import java.util.LinkedList;

public class separateChaining {
    private final int size;
    private final LinkedList<Integer>[] buckets;

    public separateChaining(int size) {
        this.size = size;
        this.buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int value) {
        return value % size;
    }

    public void separateChainingInsert(int value) {
        int index = hashFunction(value);
        buckets[index].add(value);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": " + buckets[i] + " -> null\n");
        }
    }
}
