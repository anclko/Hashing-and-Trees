package Task1;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};

        // ----------------------- Task 1A --------------------------- //
        Task1A.BinaryHeap heap1A = new Task1A.BinaryHeap(15);

        System.out.println("Task 1A: Inserting elements into BinaryHeap");
        for (int numbers : array) {
            heap1A.insert(numbers);
            heap1A.printHeap();
        }

        // ----------------------- Task 1B --------------------------- //
        Task1B.linearHeap linearHeap = new Task1B.linearHeap(array);
        System.out.println(" ");
        System.out.println("Task 1B: Result using Linear-Time Algorithm:");
        linearHeap.printHeap();
    }
}