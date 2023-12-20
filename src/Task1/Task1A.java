package Task1;

public class Task1A {
    //min-heap
    public static class BinaryHeap {
        private int[] Heap;
        private int index;
        private int size;

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

        //check if a node is leaf node
        private boolean isLeaf(int i) {
            return rightChild(i) >= size || leftChild(i) >= size;
        }

        //insert an element into the heap
        public void insert(int element) {
            if (index >= size) {
                //if heap full, no insertions
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
    }
}
