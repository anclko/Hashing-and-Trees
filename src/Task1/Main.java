package Task1;

public class Main {
    public static void main(String[] args) {
        // Task 1A: Present the result of inserting elements into a binary heap
        Task1A.BinaryHeap heap1A = new Task1A.BinaryHeap(15);
        int[] elements1A = {10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};

        System.out.println("Task 1A: Inserting elements into BinaryHeap");
        for (int element : elements1A) {
            heap1A.insert(element);
            heap1A.printHeap();
        }
    }
}