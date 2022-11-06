import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;
// for Iverson's CS211, Limit yourself to above imports
// these will help us maintain O(log N) run-time for this

/*
 * Samneet Singh
 * March 20th, 2021
 * CS 211 w/ Mr. Iverson
 * Assignment 18b
 * Purpose: To write methods for the HeapPriorityQueue class and implement the Comparable class
 */

// Implements a priority queue of comparable objects using a
// min-heap represented as an array.
public class HeapPriorityQueue<E extends Comparable<E>> {
    private E[] elementData;
    private int size;
    private Comparator<E> c;
    
    // Constructs an empty queue.
    @SuppressWarnings("unchecked")
    public HeapPriorityQueue() {
        elementData = (E[]) new Comparable[10]; // was Object
        size = 0;
        c = Comparator.naturalOrder();
    }

    // create constructor to take a comparator as an argument and use it within the program
    public HeapPriorityQueue(Comparator<E> comparator) {
        this();
        c = comparator;
    }
    // ADD METHODS HERE for exercise solutions:

    // create a constructor to take a collection as an argument and push it through as a heap
    public HeapPriorityQueue(Collection<E> collection) {
        this();
        c = Comparator.naturalOrder();
        for(E var : collection) {
            add(var);
        }

    }

    // create a method to turn the heap into an array
    public String[] toArray() {

        // check the actual size
        int actualSize = 0;

        // create a for loop to iterate through the heap to calculate the size of the heap
        for(int i = 0; i < elementData.length; i++) {
            if(elementData[i] == null) {

            } else {
                actualSize++;
            }
        }

        // create the string array that will be returned
        String[] arr = new String[actualSize];

        // iterate through the array saving the values into the string arrays
        for(int x = 0; x < actualSize; x++) {

            arr[x] = String.valueOf(elementData[x+1]);

        }

        // return the string array
        return arr;
    }

    public boolean remove(E value) {

        // value does not exist unless proven it does
        boolean exists = false;

        // iterate through the heap until the element is found
        for(int i = elementData.length - 1; i > 0; i--) {

            // if the element is found, remove it from the heap and resize
            if(elementData[i] == value) {

                int numMoves = size - i;

                for(int x = i; x < elementData.length - 1; x++) {
                    elementData[x] = elementData[x+1];
                }

                size--;

                // bubble down through the heap
                /** bubble down taken from
                 *  https://www.buildingjavaprograms.com/code-files/3ed/ch18/HeapPriorityQueue.java**/
                int index = 1;
                boolean found = false;   // have we found the proper place yet?
                while (!found && hasLeftChild(index)) {
                    int left = leftChild(index);
                    int right = rightChild(index);
                    int child = left;
                    if (hasRightChild(index) && c.compare(elementData[right], elementData[left])
                             /* elementData[right].compareTo(elementData[left]) */ < 0) {
                        child = right;
                    }

                    if (c.compare(elementData[index], elementData[child])/* elementData[index].compareTo(elementData[child]) */  > 0) {
                        swap(elementData, index, child);
                        index = child;
                    } else {
                        found = true;  // found proper location; stop the loop
                    }
                }
                /** end of bjp 'bubble down' **/
                exists = true;
                break;

            } else {
                continue;
            }
        }

        return exists;
    }
    // create poll method which removes root
    public E poll() {

        // check if the heap is empty
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        // save the value that will be returned
        E returnValue = elementData[1];

        // resize the array
        for(int x = 0; x < elementData.length - 1; x++) {
            elementData[x] = elementData[x+1];
        }
        size--;


        // bubble down (used bjp bubble down. changed to implement comparator)
        int index = 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasLeftChild(index)) {
            int left = leftChild(index);
            int right = rightChild(index);
            int child = left;
            if (hasRightChild(index) &&
                    elementData[right].compareTo(elementData[left]) < 0) {
                child = right;
            }

            if (elementData[index].compareTo(elementData[child]) > 0) {
                swap(elementData, index, child);
                index = child;
            } else {
                found = true;  // found proper location; stop the loop
            }
        }

        // return the saved value that was removed
        return returnValue;
    }

    // resizes the array to clear it
    public void clear() {
        size = 0;
    }

    // Adds the given element to this queue.
    public void add(E value) {
        // resize if necessary
        if (size + 1 >= elementData.length) { // O(N) issue here
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        
        // insert as new rightmost leaf
        elementData[size + 1] = value;
        
        // "bubble up" toward root as necessary to fix ordering
        int index = size + 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasParent(index)) {
            int parent = parent(index);
            if (c.compare(elementData[index], elementData[parent]) < 0 /* elementData[index].compareTo(elementData[parent]) < 0 */) {
                swap(elementData, index, parent(index));
                index = parent(index);
            } else {
                found = true;  // found proper location; stop the loop
            }
        }
        
        size++;
    }
    
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Returns the minimum value in the queue without modifying the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elementData[1];
    }
    
    // Removes and returns the minimum value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public E remove() {
        E result = peek();

        // move rightmost leaf to become new root
        elementData[1] = elementData[size];
        size--;
        
        // "bubble down" root as necessary to fix ordering
        int index = 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasLeftChild(index)) {
            int left = leftChild(index);
            int right = rightChild(index);
            int child = left;
            if (hasRightChild(index) && c.compare(elementData[right], elementData[left]) < 0
                    /* elementData[right].compareTo(elementData[left]) < 0 */ ) {
                child = right;
            }
            
            if (c.compare(elementData[index], elementData[child])/* elementData[index].compareTo(elementData[child]) */ > 0) {
                swap(elementData, index, child);
                index = child;
            } else {
                found = true;  // found proper location; stop the loop
            }
        }
        
        return result;
    }
    
    // Returns the number of elements in the queue.
    public int size() {
        return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += elementData[1];
            for (int i = 2; i <= size; i++) {
                result += ", " + elementData[i];
            }
        }
        return result + "]";
    }
    
    
    // helpers for navigating indexes up/down the tree
    private int parent(int index) {
        return index / 2;
    }
    
    // returns index of left child of given index
    private int leftChild(int index) {
        return index * 2;
    }
    
    // returns index of right child of given index
    private int rightChild(int index) {
        return index * 2 + 1;
    }
    
    // returns true if the node at the given index has a parent (is not the root)
    private boolean hasParent(int index) {
        return index > 1;
    }
    
    // returns true if the node at the given index has a non-empty left child
    private boolean hasLeftChild(int index) {
        return leftChild(index) <= size;
    }
    
    // returns true if the node at the given index has a non-empty right child
    private boolean hasRightChild(int index) {
        return rightChild(index) <= size;
    }
    
    // switches the values at the two given indexes of the given array
    private void swap(E[] a, int index1, int index2) {
        E temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
