/* no imports required, we're writing out own
 * optional iterator import if your curious
 * 
 * CS211, W.P. Iverson, instructor and author
 * This is a start at test code for Chapter 15 Assignment
 * Other tests can and will happen....
 * version 2019
 */
public class Post {

	public static void main(String[] args) {

		// Constructor overloaded
		ArrayIntStack bag18 = new ArrayIntStack(); // default array size
		ArrayIntStack bag99 = new ArrayIntStack(1000); // other size

		bag18.push(42); bag18.push(24); bag18.push(-33);
		// works without the generic Iterator from Oracle
		ArrayIntStack.IntStackIterator handle = bag18.iterator();
		while (handle.hasNext()) { // loop is Big-O  O(N)
			System.out.println(handle.next());
		}
		System.out.println(bag18.empty());
		System.out.println(bag18.push(42));
		System.out.println(bag18.pop());
		System.out.println(bag18.peek());
		
		// required:
		try {
			bag99.pop(); 
		} catch (Exception e) {
			System.out.println("What was thrown: " + e);
		}
		
		// required:
		try {
			for (int i=1; i<100; i++) bag18.push(i);
		} catch (Error e) {
			System.out.println("What was thrown: " + e);
		}
		
		// optional:
		// if you implement Oracle Iterable<Iterator>
		//for (Integer i : bag18) System.out.println(i);
	}

}
