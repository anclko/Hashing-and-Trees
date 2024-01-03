package Task1;

import java.util.Arrays;

public class Task1B {
    public static class linearHeap {
        private final int[] heap;
        private int size;

        // Constructor to initialize the heap with a given array of elements without automatic heapification
        public linearHeap(int[] elements) {
            // Copy the provided elements into the heap array
            this.heap = Arrays.copyOf(elements, elements.length);
            // Set the size of the heap to the length of the elements array
            this.size = elements.length;
        }

        // Method to build the heap from the array
        public void buildHeap() {
            // Start from the last non-leaf node and heapify downwards
            for (int i = (size / 2) - 1; i >= 0; i--) {
                // Call the heap algorithm for each node
                heapAlgo(i);
            }
        }

        // Method to insert a new number into the heap
        public void insert(int number) {
            if (size >= heap.length) {
                // If the heap is already full, return without inserting
                return;
            }

            // Add the new number at the end of the heap
            heap[size] = number;
            size++;

            // Re-heapify the heap after insertion
            for (int i = (size / 2) - 1; i >= 0; i--) {
                heapAlgo(i);
            }
        }

        // Helper method to perform the heapify operation
        private void heapAlgo(int i) {
            // Calculate the index of the left child
            int leftChild = 2 * i + 1;
            // Calculate the index of the right child
            int rightChild = 2 * i + 2;
            // Assume the current node is the smallest
            int smallest = i;

            // Check if the left child is smaller than the current node
            if (leftChild < size && heap[leftChild] < heap[smallest]) {
                smallest = leftChild;
            }

            // Check if the right child is smaller than the smallest found so far
            if (rightChild < size && heap[rightChild] < heap[smallest]) {
                smallest = rightChild;
            }

            // If either child is smaller, swap and continue heapifying
            if (smallest != i) {
                // Swap the current node with the smallest child
                swap(i, smallest);
                // Continue heapifying at the child node
                heapAlgo(smallest);
            }
        }

        // Method to swap two elements in the heap
        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        // Method to print the elements of the heap
        public void printHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }

        //----------------------------------------- TASK 1C ----------------------------------//

        // Method for in-order traversal of the heap
        public void inOrder(int root) {
            if (root < size) {
                // Recursively visit the left child
                inOrder(2 * root + 1);
                // Visit the root node
                System.out.print(heap[root] + " ");
                // Recursively visit the right child
                inOrder(2 * root + 2);
            }
        }

        // Method for pre-order traversal of the heap
        public void preOrder(int root) {
            if (root < size) {
                // Visit the root node
                System.out.print(heap[root] + " ");
                // Recursively visit the left child
                preOrder(2 * root + 1);
                // Recursively visit the right child
                preOrder(2 * root + 2);
            }
        }

        // Method for post-order traversal of the heap
        public void postOrder(int root) {
            if (root < size) {
                // Recursively visit the left child
                postOrder(2 * root + 1);
                // Recursively visit the right child
                postOrder(2 * root + 2);
                // Visit the root node
                System.out.print(heap[root] + " ");
            }
        }

        // Method for level-order traversal of the heap
        public void levelOrder() {
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
        }
    }
}
