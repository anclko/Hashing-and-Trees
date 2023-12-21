package Task1;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};

        // ----------------------- Task 1A + 1C --------------------------- //
        Task1A.BinaryHeap heap1A = new Task1A.BinaryHeap(15);

        System.out.println("Task 1A: Inserting elements");
        for (int numbers : array) {
            heap1A.insert(numbers);
            heap1A.printHeap();
        }

        System.out.println("\nTask 1C: Traversals For Algorithm 1");
        System.out.println("In-Order Traversal:");
        heap1A.inOrder(0);
        System.out.println("\nPre-Order Traversal:");
        heap1A.preOrder(0);
        System.out.println("\nPost-Order Traversal:");
        heap1A.postOrder(0);
        System.out.println("\nLevel-Order Traversal:");



        System.out.println("\n---------------------------- Algorithm 2 ---------------------------------");
        // ----------------------- Task 1B + 1C --------------------------- //
        Task1B.linearHeap linearHeap = new Task1B.linearHeap(array);
        System.out.println("Task 1B: Linear Time Algorithm:");
        linearHeap.printHeap();
    }
}