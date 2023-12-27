package Task1;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};
        int[] arraySizeTaskD = {100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000};

        // ----------------------- Task 1A + 1C --------------------------- //
        System.out.println("\n---------------------------- Algorithm 1 ---------------------------------");
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
        heap1A.levelOrder();
        System.out.println(" ");

        // ----------------------- Task 1B + 1C --------------------------- //
        System.out.println("\n---------------------------- Algorithm 2 ---------------------------------");
        Task1B.linearHeap heap1B = new Task1B.linearHeap(array);
        System.out.println("\nTask 1B: Linear Time Algorithm:");
        for (int numbers : array) {
            heap1B.insert(numbers);
            heap1B.printHeap();
        }

        System.out.println("\nTask 1C: Traversals For Algorithm 2");
        System.out.println("In-Order Traversal:");
        heap1B.inOrder(0);
        System.out.println("\nPre-Order Traversal:");
        heap1B.preOrder(0);
        System.out.println("\nPost-Order Traversal:");
        heap1B.postOrder(0);
        System.out.println("\nLevel-Order Traversal:");
        heap1B.levelOrder();
        System.out.println(" ");

        // ----------------------- Task 1D --------------------------- //
        System.out.println("\n---------------------------- Measure of Complexity ---------------------------------");
        for (int size : arraySizeTaskD) {
            System.out.println("\n--------------------- Size: " + size + " ---------------------");

            runTask1A(size, 10);
            runTask1B(size, 10);
        }
    }

    public static void runTask1A(int size, int numCycles) {
        long totalElapsedTime = 0;

        for (int i = 0; i < numCycles; i++) {
            Task1A.BinaryHeap heap1Da = new Task1A.BinaryHeap(size);

            long startTime1Da = System.nanoTime();
            for (int number : randomArray(size)) {
                heap1Da.insert(number);
            }
            long endTime1Da = System.nanoTime();

            totalElapsedTime += (endTime1Da - startTime1Da);
        }

        long averageTime = totalElapsedTime / numCycles;

        System.out.println("Task 1A: Average insertion time for size " + size + " over " + numCycles + " cycles: " + averageTime + " nanoseconds");
    }

    public static void runTask1B(int size, int numCycles) {
        long totalElapsedTime = 0;

        for (int i = 0; i < numCycles; i++) {
            Task1B.linearHeap heap1Db = new Task1B.linearHeap(randomArray(size));

            long startTime1Db = System.nanoTime();
            heap1Db.buildHeap();
            long endTime1Db = System.nanoTime();

            totalElapsedTime += (endTime1Db - startTime1Db);
        }

        long averageTime = totalElapsedTime / numCycles;

        System.out.println("Task 1B: Average linear time for size " + size + " over " + numCycles + " cycles: " + averageTime + " nanoseconds");
    }

    private static int[] randomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1_000_000);
        }
        return array;
    }
}