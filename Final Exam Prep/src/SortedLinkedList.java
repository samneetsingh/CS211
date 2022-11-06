//  NO IMPORTS ALLOWED

/* Class SortedLinkedList<E> for final exam day
*  from Buildingjavaprograms.com
*  copyright Bellevue College, March 2021
*  added backwards() to check list in backwards order
*  plus many changes to enforce no imports, just java.lang.*
*/
public class SortedLinkedList<E extends Comparable<E>> { 
	// FIELDS:
    private ListNode<E> front;  // leftmost node of the list
    private ListNode<E> back;   // rightmost node of the list
    private int size;           // current number of elements

    // post: constructs an empty list
    public SortedLinkedList() {
        front = new ListNode<E>(null);
        back = new ListNode<E>(null);
        clear();
    }

    // TOTAL HACK, just to get three data points loaded
    // Keep this poor constructor, so initial testing is possible
    // Later on we'll write a better .add method and constructor(s)
	public SortedLinkedList(E i, E j, E k) {
		ListNode<E> a = new ListNode<E>(i,null,null);
		ListNode<E> b = new ListNode<E>(j,null,a);
		ListNode<E> c = new ListNode<E>(k,null,b);
        front = new ListNode<E>(null,a,null);
        back = new ListNode<E>(null,null,c);
        a.right = b; a.left = front;
		b.right = c;
		front.right = a;
		back.left = c;
		c.right = back;
		size = 3;
	}
    
// ADD METHODS (CONSTRUCTORS) FOR EXAM HERE: 
	// 1. count data items
	// 2. removeDuplicates
	// 3. deleteLast with O(constant) required 
	// 4. add method, that adds into correct position
	// 5. Constructor to load in any array for initial values
    

	// Code just to get things started:
	
	// 1.
	public int countData(E data) {

        ListNode<E> curr1 = front.right;
        int count = 0;

        for(int i = 0; i < size; i++) {

            if(curr1 != null) {

                while(curr1.data == data) {
                    count++;
                    curr1 = curr1.right;
                }

                curr1 = curr1.right;
            } else{
                break;
            }


        }
        return count;
	}

	// 2.
/*	public void removeDuplicates() {

        if(front.left == null){
            return;
        }

        ListNode<E> curr1 = front.right;
        ListNode<E> curr2 = back.left;

        while(curr1.right != null) {

             if(countData(curr1.data) > 1) {
                ListNode<E> curr2 = back.left;
                for(int i = 0; i < countData(curr1.data); i++) {
                    while(curr2.left != curr1.data) {
                        curr2 = curr2.left;
                    }
                    curr1.right = curr1.right.right;
                    curr2.left = curr2.left.left;
                }
            }
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

	} */
    public void removeDuplicates() {
        ListNode<E> currFront = front.right;
        //Node current will point to head
        ListNode <E> current, index, temp;

        //Checks whether list is empty
        if(currFront == null) {
            return;
        }
        else {
            //Initially, current will point to head node
            for(current = currFront; current != null; current = current.right) {
                //index will point to node next to current
                for(index = current.right; index != null; index = index.right) {
                    if(current.data == index.data) {
                        //Store the duplicate node in temp
                        temp = index;
                        //index's previous node will point to node next to index thus, removes the duplicate node
                        index.left.right = index.right;
                        if(index.right != null)
                            index.right.left = index.left;
                        //Delete duplicate node by making temp to null
                        temp = null;
                        size--;
                    }
                }
            }
        }
    }

	// 3.
	public E deleteLast() {

        E value = back.left.data;

        ListNode<E> curr = front.right;

        curr = back.left;
        back = back.left;

		return value;
	}
	
	// 4.
	public boolean add(E item) {

        ListNode<E> curr1 = front.right;

		while(curr1 != null && curr1.data != null) {

		    if(size == 0) {
                ListNode<E> newItem = new ListNode<E>(item, back, front);
                front.right = newItem;
                back.left = newItem;
                size++;
                break;
		    } else if((curr1.data).compareTo(item) > 0) {
		        ListNode<E> newItem = new ListNode<E>(item, curr1, curr1.left);
                front.right = newItem;
                front.right.right.left = newItem;
		        size++;
		        break;
		    } else if((curr1.data).compareTo(item) < 0 && curr1.right == back) {
                ListNode<E> newItem = new ListNode<E>(item, back, curr1.left);
                curr1.right = newItem;
                back.left = newItem;
                size++;
                break;
            } else if((curr1.data).compareTo(item) < 0 && curr1.right != back) {

            }
		    curr1 = curr1.right;
        }
        return true;
	}
	
	// 5.
	public SortedLinkedList(E[] array) {
		this();
        for(E value : array) {
            this.add(value);
        }
	}
	

    
//-------------------------------------------------------------------------
    // Below here is provided code from textbook, modified for CS211 exam
    
    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + front.right.data;
            ListNode<E> current = front.right.right;
            while (current != back) {
                result += ", " + current.data;
                current = current.right;
            }
            result += "]";
            return result;
        }
    }
    
    // post: creates a comma-separated, bracketed version of the list
    // Creation to test reverse links in order
    public String backwards() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + back.left.data;
            ListNode<E> current = back.left.left;
            while (current != front) {
                result += ", " + current.data;
                current = current.left;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(E value) {
        int index = 0;
        ListNode<E> current = front.right;
        while (current !=  back) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.right;
        }
        return -1;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    // post: list is empty
    public void clear() {
        front.right = back;
        back.left = front;
        size = 0;
    }

//----------------------------------------------------------------------------
    // INNER Class to provide nodes for this linked list
    // changed to right and left so list could easily adapt to reversals

    private static class ListNode<E> {
        public E data;         	// data stored in this node
        public ListNode<E> right;  // link to the conceptual right 
        public ListNode<E> left;  // link to the conceptual left 
        // post: constructs a node with given data and null links
        public ListNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with given data and given links
        public ListNode(E item, ListNode<E> first, ListNode<E> second) {
            data = item;
            right = first;
            left = second;
        }
    }
}