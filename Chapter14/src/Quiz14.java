import java.util.LinkedList;
import java.util.Queue;
/*
 * Samneet Singh
 * February 17th, 2021
 * CS 211 w/ Mr. Iverson
 * Quiz 14
 * Purpose: To create the reverseOddHalf method
 */
public class Quiz14 {
    public static void main(String[] q14) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(8);
        stack.push(7);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        stack.push(12);
        stack.push(0);

        System.out.println("bottom " + stack.toString() + " top");
        reverseOddHalf(stack);
        System.out.println("bottom " + stack.toString() + " top");
    } // your solution should follow below

    public static void reverseOddHalf(Stack<Integer> s1) {

        Queue<Integer> q = new LinkedList<Integer>(); // create a new queue for aux storage

        // copy the whole stack into a queue
        while (!s1.empty()) {
            q.add(s1.pop());
        }
        while (!q.isEmpty()) {
            s1.push(q.remove());
        }
        while (!s1.empty()){
            q.add(s1.pop());
        }
        // create a new stack to use as aux storage
        Stack<Integer> s2 = new Stack<Integer>();
        // create an int size
        int size = q.size();
        // create a for loop to change the queue according to the required info given by Iverson
        for(int i = 0; i < size; i++) {
            if(i % 2 == 1)
                s2.push(q.remove());
            else
                q.add(q.remove());
        }
        // transfer the queue back into a stack
        while(!s2.empty()) {
            q.add(q.remove());
            q.add(s2.pop());
        }

        if(size % 2 == 1)
            q.add(q.remove());

        while(!q.isEmpty()){
            s1.push(q.remove());
        }
    } // finished (that was really hard)
}