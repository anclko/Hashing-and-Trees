package Task2;

import java.util.LinkedList;

public class SeparateChaining {
    private int size;
    private LinkedList<Integer>[] hashTable;

    //Constructor
    public void SeparateChainingTable(int size){
        this.size = size;
        hashTable = new LinkedList[size];
    }

    //function to determine index of key
    private int hashFunction(int key) {
        return key % size;
    }

    //insert function: put key into hash table - seperate chaining
    //-determine index
    //-create linked list
    //-add key to linked list

    //display
}
