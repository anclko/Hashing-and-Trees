package Task2;

import java.util.LinkedList;

public class separateChaining {
    private int size;
    private LinkedList<Integer>[] buckets;

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

    public void rehash() {
        int newSize = size * 2;
        LinkedList<Integer>[] newBuckets = new LinkedList[newSize];

        for (LinkedList<Integer> bucket : buckets) {
            for (int item : bucket) {
                int index = item % newSize;
                if (newBuckets[index] == null) {
                    newBuckets[index] = new LinkedList<>();
                }
                newBuckets[index].add(item);
            }
        }

        size = newSize;
        buckets = newBuckets;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            LinkedList<Integer> bucket = buckets[i];
            System.out.print("Slot " + i + ": ");
            if (bucket != null && !bucket.isEmpty()) {
                for (int item : bucket) {
                    System.out.print(item + " ");
                }
            }
            System.out.println();
        }
    }
}
