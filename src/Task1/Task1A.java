package Task1;

public class Task1A {
    // Class to implement a min-heap data structure
    public static class BinaryHeap {
        private final int[] Heap;
        private int index;
        private final int size;

        // Constructor to initialize the heap with a specified maximum size
        public BinaryHeap(int size) {
            this.size = size;
            this.index = 0;
            // Allocate memory for the heap array
            Heap = new int[size];
        }

        // Method to calculate the index of the parent node of a given node
        private int parent(int i) {
            return (i - 1) / 2;
        }

        // Method to calculate the index of the left child of a given node
        private int leftChild(int i) {
            return (i * 2) + 1;
        }

        // Method to calculate the index of the right child of a given node
        private int rightChild(int i) {
            return (i * 2) + 2;
        }

        // Method to insert an element into the heap
        public void insert(int element) {
            if (index >= size) {
                // If the heap is full, do not insert and return
                return;
            }
            // Insert the new element at the current index
            Heap[index] = element;
            int current = index;

            // Adjust the heap by moving the new element up until the min-heap property is satisfied
            while (Heap[current] < Heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
            // Increase the size of the heap
            index++;
        }

        // Method to print the elements of the heap
        public void printHeap() {
            for (int i = 0; i < index; i++) {
                System.out.print(Heap[i] + " ");
            }
            System.out.println();
        }

        // Method to swap two nodes in the heap
        private void swap(int x, int y) {
            // Temporary variable to hold the value of node x
            int tmp = Heap[x];
            // Place the value of node y in node x
            Heap[x] = Heap[y];
            // Place the original value of node x in node y
            Heap[y] = tmp;
        }

        // Method for in-order traversal of the heap
        public void inOrder(int root) {
            if (root < index) {
                // Recursively visit the left subtree
                inOrder(leftChild(root));
                // Visit the root node
                System.out.print(Heap[root] + " ");
                // Recursively visit the right subtree
                inOrder(rightChild(root));
            }
        }

        // Method for pre-order traversal of the heap
        public void preOrder(int root) {
            if (root < index) {
                // Visit the root node
                System.out.print(Heap[root] + " ");
                // Recursively visit the left subtree
                preOrder(leftChild(root));
                // Recursively visit the right subtree
                preOrder(rightChild(root));
            }
        }

        // Method for post-order traversal of the heap
        public void postOrder(int root) {
            if (root < index) {
                // Recursively visit the left subtree
                postOrder(leftChild(root));
                // Recursively visit the right subtree
                postOrder(rightChild(root));
                // Visit the root node
                System.out.print(Heap[root] + " ");
            }
        }

        // Method for level-order traversal of the heap
        public void levelOrder() {
            for (int i = 0; i < index; i++) {
                System.out.print(Heap[i] + " ");
            }
        }

    }
}
