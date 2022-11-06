import java.util.*;
// Implements a set of objects using a hash table.
// The hash table uses separate chaining to resolve collisions.
// Original from buildingjavaprograms.com supplements
// minor edits by Bill Iverson, Bellevue College, January 2020

/*
 * Samneet Singh
 * March 17th, 2021
 * CS 211 w/ Mr. Iverson
 * Assignment 18a
 * Purpose: To write backwards() method which just reverses the passed hashset
 */
public class HashSet<E> {
    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry<E>[] elementData;
    private int size;
    
    // Constructs an empty set.
    @SuppressWarnings("unchecked")
	public HashSet() {
        elementData = new HashEntry[10];
        size = 0;
    }
    
    // ADD METHODS HERE for exercise solutions:
    public String backwards() {

        // create result string and necessary auxiliary storage
        String result = "[]";
        Stack<E> aux = new Stack<E>();
        Queue<E> q = new LinkedList<E>();

        // run only if the set is not empty
        if (!isEmpty()) {

            // loop through and push all data into a stack
            for (int i = 0; i < elementData.length; i++) {
                HashEntry<E> current = elementData[i];
                while(current != null) {
                    aux.push(current.data);
                    current = current.next;
                }
            }
            // push stack through to a queue to reverse
            while(!aux.empty())  {
                q.add(aux.pop());
            }
            // set the value of result to the value of the queue (or the stack reversed)
            result = q.toString();

        }
        return result;
    }

    public String toString2() {

        String result = ""; // create result string

        // create a loop to print the headers
        for (int i = 0; i <elementData.length; i++) {
            System.out.print(String.format("%-10s", "[" + i + "]"));
        }

        // check if empty. if so, run method
        if(!isEmpty()) {
            System.out.println();

            // initialize necessary variables
            int element = size;
            int lvl = 1;
            HashEntry<E> curr = null;

            // create a while loop that checks for 0 cases
            while(element != 0) {

                // create looping
                for(int i =0; i <elementData.length; i++) {

                    // set curr to the value stored in the given index of the set
                    curr = elementData[i];

                    // iterate through curr values
                    if(curr != null && curr.data.hashCode() % elementData.length == i) {

                        for (int j = 1; j < lvl; j++) {

                            if(curr.next != null && curr.next.data.hashCode() % elementData.length == i) {

                                curr = curr.next;

                            } else {

                                curr = null;
                                System.out.print(String.format("%" + 10 + "s", ""));
                                break;

                            }
                        }

                        // lower the amount of looping left
                        if(curr != null) {

                            System.out.print(String.format( "%-10s", (curr.data)));
                            element--;

                        }
                    } else {
                        System.out.print(String.format("%" + 10 + "s", ""));
                        result = "";
                    }
                }

                System.out.println();
                lvl++;
            }
        }

        //return the result string
         return result = result + "";
    }
    
    
    
    
    
    
    
    
    
    
    
    // Adds the given element to this set, if it was not already
    // contained in the set.
    public void add(E value) {
        if (!contains(value)) {
            if (loadFactor() >= MAX_LOAD_FACTOR) {
                rehash();
            }
            
            // insert new value at front of list
            int bucket = hashFunction(value);
            elementData[bucket] = new HashEntry<E>(value, elementData[bucket]);
            size++;
        }
    }
    
    // Removes all elements from the set.
    public void clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
    }
    
    // Returns true if the given value is found in this set.
    public boolean contains(E value) {
        int bucket = hashFunction(value);
        HashEntry<E> current = elementData[bucket];
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Returns true if there are no elements.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    public void remove(E value) {
        int bucket = hashFunction(value);
        if (elementData[bucket] != null) {
            // check front of list
            if (elementData[bucket].data.equals(value)) {
                elementData[bucket] = elementData[bucket].next;
                size--;
            } else {
                // check rest of list
                HashEntry<E> current = elementData[bucket];
                while (current.next != null && !current.next.data.equals(value)) {
                    current = current.next;
                }
                
                // if the element is found, remove it
                if (current.next != null && current.next.data.equals(value)) {
                    current.next = current.next.next;
                    size--;
				}
            }
        }
    }
    
    // Returns the number of elements.
    public int size() {
        return size;
    }
    
    // Returns a string representation such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        boolean first = true;
        if (!isEmpty()) {
            for (int i = 0; i < elementData.length; i++) {
                HashEntry<E> current = elementData[i];
                while (current != null) {
                    if (!first) {
                        result += ", ";
                    }
                    result += current.data;
                    first = false;
                    current = current.next;
                }
            }
        }
        return result + "]";
    }
    
    
    // Returns the preferred hash bucket index for the given value.
    private int hashFunction(E value) {
        return Math.abs(value.hashCode()) % elementData.length;
    }
    
    private double loadFactor() {
        return (double) size / elementData.length;
    }
    
    // Resizes the hash table to twice its former size.
    @SuppressWarnings("unchecked")
	private void rehash() {
        // replace element data array with a larger empty version
        HashEntry<E>[] oldElementData = elementData;
        elementData = new HashEntry[2 * oldElementData.length];
        size = 0;

        // re-add all of the old data into the new array
        for (int i = 0; i < oldElementData.length; i++) {
            HashEntry<E> current = oldElementData[i];
            while (current != null) {
                add((E)current.data);
                current = current.next;
            }
        }
    }
    
    // Represents a single value in a chain stored in one hash bucket.
    @SuppressWarnings("hiding")
	private class HashEntry<E> {
        public E data;
        public HashEntry<E> next;

        @SuppressWarnings("unused")
		public HashEntry(E data) {
            this(data, null);
        }

        public HashEntry(E data, HashEntry<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
