/* CS211  Winter 2021, Final exam
 * W.P. Iverson, instructor
 * Copyright Bellevue College
 */
public class Winter2021Final {

	public static void main(String[] args) {
		Integer[] loader = {42,-5,42};
		SortedLinkedList<Integer> init = new SortedLinkedList<Integer>(-5,42, 45);
		
		// 1. count data occurrences
		System.out.println("#1 initial: " + init); 
		System.out.println("count 42's = " + init.countData(42)); // 2
		
		// 2. removeDuplicates
		System.out.println("\n#2, before: " + init); 
		init.removeDuplicates();
		System.out.println(init.toString()); // [-5, 42]
		System.out.println(init.backwards()); // [42, -5]
		System.out.println(init.size()); // 2
		
		// 3. deleteLast with O(constant) required
		System.out.println("\n#3, before: " + init); // [-5, 42]
		System.out.println(init.deleteLast()); // 42
		System.out.println(init);  // [-5]

		// 4. add cases to test: first, end, middle of list
		init.add(-22);//  init.add(333);  init.add(1);
		System.out.println("\nafter add: " + init); // [-22, -5, 1, 333]
		System.out.println("backwards: " + init.backwards()); // [333, 1, -5, -22]
		
		// 5. Constructor to load in any array for initial values
		SortedLinkedList<Integer> uno = new SortedLinkedList<Integer>(loader);
		System.out.println("\n#5: " + uno); // [-5, 42, 42]
		
		// Additional testing to be sure using .compareTo correctly
		// also testing to be sure left and right links are all intact
		String[] more = {"one", "two", "three", "four"};
		SortedLinkedList<String> dos = new SortedLinkedList<String>(more);
		System.out.println("\nAdditional testing: " + dos);
		dos.add("one"); dos.add("two"); dos.add("three");
		System.out.println(dos);
		dos.removeDuplicates();
		dos.deleteLast();
		System.out.println(dos);
		System.out.println(dos.backwards());
		// Can never have too many test cases....
	}
}
