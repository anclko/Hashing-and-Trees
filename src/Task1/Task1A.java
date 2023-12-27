package Task1;

public class Task1A {
    //min-heap
    public static class BinaryHeap {
        private final int[] Heap;
        private int index;
        private final int size;

        // Constructor
        public BinaryHeap(int size) {
            this.size = size;
            this.index = 0;
            Heap = new int[size];
        }

        //calculate the index of parent of a node
        private int parent(int i) {
            return (i - 1) / 2;
        }

        //calculate the index of left child of a node
        private int leftChild(int i) {
            return (i * 2) + 1;
        }

        //calculate the index of right child of a node
        private int rightChild(int i) {
            return (i * 2) + 2;
        }

        //insert an element into the heap
        public void insert(int element) {
            if (index >= size) {
                //if heap full dont insert
                return;
            }
            //insert element at the current index
            Heap[index] = element;
            int current = index;

            //move element up the heap until heap property is restored
            while (Heap[current] < Heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
            index++;
        }

        // Method to print the contents of the heap into array
        public void printHeap() {
            for (int i = 0; i < index; i++) {
                System.out.print(Heap[i] + " ");
            }
            System.out.println();
        }

        // Method to swap two nodes of the heap
        private void swap(int x, int y) {
            int tmp = Heap[x];
            Heap[x] = Heap[y];
            Heap[y] = tmp;
        }

        //----------------------------------------- TASK 1C ----------------------------------//
        public void inOrder(int root) {
            //check if within bounds
            if (root < index) {
                //traverse left recursively
                inOrder(leftChild(root));
                //print value of current node
                System.out.print(Heap[root] + " ");
                //go through right
                inOrder(rightChild(root));
            }
        }

        public void preOrder(int root) {
            if (root < index) {
                System.out.print(Heap[root] + " ");
                preOrder(leftChild(root));
                preOrder(rightChild(root));
            }
        }

        public void postOrder(int root) {
            //opposite of preorder - node at end
            if (root < index) {
                postOrder(leftChild(root));
                postOrder(rightChild(root));
                System.out.print(Heap[root] + " ");
            }
        }

        public void levelOrder() {
            for (int i = 0; i < index; i++) {
                System.out.print(Heap[i] + " ");
            }
        }

    }
}
