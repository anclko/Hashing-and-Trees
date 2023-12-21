package Task1;

import java.util.Arrays;

public class Task1B {
    public static class linearHeap {
        private final int[] heap;
        private final int size;

        public linearHeap(int[] elements) {
            this.heap = Arrays.copyOf(elements, elements.length);
            this.size = elements.length;
            linearTime();
        }

        private void linearTime() {
            //look from the last non-leaf node and perform heapify
            //for linear time
            for (int i = (size / 2) - 1; i >= 0; i--) {
                heapify(i);
            }
        }

        private void heapify(int i) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int smallest = i;

            if (leftChild < size && heap[leftChild] < heap[smallest]) {
                smallest = leftChild;
            }

            if (rightChild < size && heap[rightChild] < heap[smallest]) {
                smallest = rightChild;
            }

            if (smallest != i) {
                swap(i, smallest);
                heapify(smallest);
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void printHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }

        //----------------------------------------- TASK 1C ----------------------------------//

        public void inOrder(int root) {
            if (root < size) {
                //going through left child of current root
                inOrder(2 * root + 1);
                System.out.print(heap[root] + " ");
                //going through right child of current root
                inOrder(2 * root + 2);
            }
        }

        public void preOrder(int root) {
            if (root < size) {
                System.out.print(heap[root] + " ");
                preOrder(2 * root + 1);
                preOrder(2 * root + 2);
            }
        }

        public void postOrder(int root) {
            if (root < size) {
                postOrder(2 * root + 1);
                postOrder(2 * root + 2);
                System.out.print(heap[root] + " ");
            }
        }

        public void levelOrder() {
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
        }
    }
}
