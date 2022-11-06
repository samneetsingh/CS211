import java.util.*;
// Class LinkedList<E> can be used to store a list of values of type E.
// from Buildingjavaprograms.com (2015)
// modified by W.P. Iverson, Bellevue College, January 2021 
// added backwards(); to check list in backwards order

/*
 * Samneet Singh
 * March 3rd, 2021
 * CS 211 w/ Mr. Iverson
 * Quiz 16
 * Purpose: To write methods for the linkedList class
 */
public class LinkedList<E extends Comparable<E>> implements Iterable<E>{  
	// 2017, removed implements List due to version differences of List
    private ListNode<E> front;  // first value in the list
    private ListNode<E> back;   // last value in the list
    private int size;           // current number of elements

    // NOTE: an empty list has TWO Nodes to mark front and back
    // post: constructs an empty list
    public LinkedList() {
        front = new ListNode<E>(null);
        back = new ListNode<E>(null);
        clear();
    }
    
// ADD MORE METHODS HERE (like for assigned CS211 work):

    public boolean isPerfectMirror() {

        // create current nodes for method
        ListNode<E> curr1 = front.next;
        ListNode<E> curr2 = back.prev;

        // create halfway point in size
        int half = size / 2;

        // create a boolean value that will be returned
        boolean perfectMirror = false;

        // check if the size is even. if not, return false
        if(size % 2 != 0 || size == 0) {
            return false;
        } else {

            // create a for loop that checks if the data is a mirror
            for (int i = 0; i < half; i++) {
                if (curr1.data == curr2.data) {

                    // since the data is equal (for this iteration), reset the currs to check the next value
                    curr1 = curr1.next;
                    curr2 = curr2.prev;

                    // since the data so far is equal, set perfect mirror to true
                    perfectMirror = true;

                } else if (curr1.data != curr2.data) {

                    // if the perfect mirror is broken, break the for loop
                    perfectMirror = false;
                    break;
                }

            }

            // return whether it's a perfect mirror
            return perfectMirror;
        }
    }

    public void removeDuplicates() {

        if(front.left == null){
            return;
        }

        ListNode<E> curr1 = front.right;
        ListNode<E> curr2 = back.left;

        while(curr1.right != null) {

            if((curr1.data).compareTo(curr1.right.data) == 0) {

                E value = curr1.data;

                while(curr2.left.data != value) {
                    curr2 = curr2.left;
                }

                curr1 = curr1.right;
                curr2 = curr2.left;
            }

            curr2 = back.left;
            curr1 = curr1.right;
        }

    }
    public int returnNumDuplicates(E value) {

        ListNode<E> curr1 = front.next;
        int count = 0;

        for(int i = 0; i < size; i++) {

            if(curr1 != null) {

                while(curr1.data == value) {
                    count++;
                    curr1 = curr1.next;
                }

                curr1 = curr1.next;
            } else{
                break;
            }


        }
        return count;
    }

    public void removeDuplicates() {
        /* if list is empty */
        ListNode<E> curr1 = front.next;
        ListNode<E> curr2 = front.next;

        if (curr1== null)
            return;

        ListNode<E> current = front.next;

        /* traverse the list till the last node */
        while (current.next != null) {
            /* Compare current node with next node */
            if (current.data == current.next.data) {
                /* delete the node pointed to by
              ' current->next' */

                if (front == current.next) {
                    front = current.next.next;
                }
        /* Change next only if node to be deleted
        is NOT the last node */
                if (current.next.next != null) {
                    current.next.next.prev = current.next.prev;
                }
        /* Change prev only if node to be deleted
       is NOT the first node */
                if (current.next.prev != null)
                    current.next.prev.next = current.next.next;

                    /* else simply move to the next node */
                else
                    current = current.next;
            }
        }

    }
    public void undoMirror() {

        // check if isPerfectMirror is at all true
        if(isPerfectMirror()) {

            // create half variable
            int half = size / 2;

            // create curr1 and set it to the first spot in the list
            ListNode<E> curr1 = front.next;

            // create a for loop to bring curr1 to the midpoint of the list
            for(int i = 1; i < half; i++) {
                curr1 = curr1.next;
            }

            // create a for loop that goes through and repoints all pointers backwards till midpoint
            for(int x = 0; x < half; x++) {
                back.prev = back.prev.prev;
                back.prev.next = back;
            }

        } else {} // make sure the method does nothing if it's not a perfect mirror
        System.out.println(front.next.next.data);
    }

public void stutter() {
    ListNode<E> curr = front.next;
    while (curr.next != null) {
        ListNode<E> dupl = new ListNode<>(curr.data);
        ListNode<E> temp = curr.next;

        // assign first half
        curr.next = dupl;
        dupl.prev = curr;

        // assign second half
        dupl.next = temp;
        temp.prev = dupl;
        curr = temp;
    }
}

    public void removeAll(E remove) {

        ListNode<E> curr = front;

        while(curr.next != null) { // stop one before null

            if(curr.next.data == remove) { // check if its what you want to remove

                // remove it from the list
                curr.next = curr.next.next;
                curr.next.prev = curr;

            } else {
                // continue going through the list
                curr = curr.next;

            }
        }
    }

    public E deleteBack() {

        if (front == null || size == 0) { // make sure its not empty

            throw new NoSuchElementException();

        } else { // remove the last value in the list and return it
            E deleted = back.prev.data;
            back.prev = back.prev.prev;
            back.prev.next = back;
            return deleted;
        }



    }

    public void switchPairs() {

        ListNode<E> curr = front.next; // create curr for the method

        if (front == null || size == 0) {
            // if the list is empty do nothing
        }

        else if((size + 1) % 2 == 0) { // check if size matches special parameters

            while (curr != null && curr.next.next != null) { // loop to make sure it doesn't go past

                // swap the pairs throughout the list for size odd
                ListNode<E> first = curr;
                ListNode<E> second = curr.next;
                E temp = first.data;
                first.data = second.data;
                second.data = temp;
                curr = curr.next.next;

            }

        } else {

            while (curr != null && curr.next.next != null) {

                // swap the pairs throughout the list for size even
                ListNode<E> first = curr;
                ListNode<E> second = curr.next;
                E temp = first.data;
                first.data = second.data;
                second.data = temp;
                curr = curr.next;

            }
        }
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the value at the given index in the list
    public E get(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        return current.data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + front.next.data;
            ListNode<E> current = front.next.next;
            while (current != back) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
    
    // post: creates a comma-separated, bracketed version of the list
    // Iverson creation
    public String backwards() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + back.prev.data;
            ListNode<E> current = back.prev.prev;
            while (current != front) {
                result += ", " + current.data;
                current = current.prev;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(E value) {
        int index = 0;
        ListNode<E> current = front.next;
        while (current !=  back) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    // post: appends the given value to the end of the list
    public void add(E value) {
        add(size, value);
    }

    // pre: 0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent values right
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ListNode<E> current = nodeAt(index - 1);
        ListNode<E> newNode = new ListNode<E>(value, current.next, current);
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    // post: appends all values in the given list to the end of this list
    public void addAll(List<E> other) {
        for (E value: other) {
            add(value);
        }
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index - 1);
        current.next = current.next.next;
        current.next.prev = current;
        size--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the value at the given index with the given value
    public void set(int index, E value) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        current.data = value;
    }

    // post: list is empty
    public void clear() {
        front.next = back;
        back.prev = front;
        size = 0;
    }

    // post: returns an iterator for this list
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    // pre : 0 <= index < size()
    // post: returns the node at a specific index.  Uses the fact that the list
    //       is doubly-linked to start from the front or the back, whichever
    //       is closer.
    private ListNode<E> nodeAt(int index) {
        ListNode<E> current;
        if (index < size / 2) {
            current = front;
            for (int i = 0; i < index + 1; i++) {
                current = current.next;
            }
        } else {
            current = back;
            for (int i = size; i >= index + 1; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    private static class ListNode<E> {
        public E data;         // data stored in this node
        public ListNode<E> next;  // link to next node in the list
        public ListNode<E> prev;  // link to previous node in the list

        // post: constructs a node with given data and null links
        public ListNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with given data and given links
        public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private class LinkedIterator implements Iterator<E> {
        private ListNode<E> current;  // location of next value to return
        private boolean removeOK;  // whether it's okay to remove now

        // post: constructs an iterator for the given list
        public LinkedIterator() {
            current = front.next;
            removeOK = false;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return current != back;
        }

        // pre : hasNext()
        // post: returns the next element in the iteration
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = current.data;
            current = current.next;
            removeOK = true;
            return result;
        }

        // pre : next() has been called without a call on remove (i.e., at most
        //       one call per call on next)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ListNode<E> prev2 = current.prev.prev;
            prev2.next = current;
            current.prev = prev2;
            size--;
            removeOK = false;
        }
    }
}