/*
 * Samneet Singh
 * February 15th, 2021
 * CS 211 w/ Mr. Iverson
 * Assignment #14
 * Purpose: Complete exercises 2, 5, 15, and 19 in order to
 * understand the concepts of stack and queue using Iverson's
 * stack class
 */

import java.util.*;

public class Chapter14 {

    // Exercise #2 stutter method below:
    public static Stack<CalendarDate> stutter(Stack<CalendarDate> testAll){
        Queue<CalendarDate> queue = new LinkedList<CalendarDate>(); // create a queue to use for aux. storage
        Stack<CalendarDate> stack = new Stack<CalendarDate>();

        // add the whole stack to the queue
        while(!testAll.empty()){
            queue.add(testAll.pop());
        }
        // reverse the stack
        while(!queue.isEmpty()){
            testAll.push(queue.remove());
        }

        // put reverse back into queue
        while(!testAll.empty()){
            queue.add(testAll.pop());
        }

        // move all back to stack with a 'stutter'
        while(!queue.isEmpty()){
            CalendarDate n = queue.remove();
            stack.push(n);
            stack.push(n);
            testAll.push(n);
        }
        return stack; // return the stack
    }

    // Exercise #5 equals method below:
    public static boolean equals(Stack<CalendarDate> stack1, Stack<CalendarDate> stack2){
        boolean areEqual = true;
        boolean check = true;

        // check for congruency
        if (stack1 == stack2){
            return true;
        }
        Stack<CalendarDate> temp = new Stack<CalendarDate>(); // create aux. storage

        if(stack1.size() != stack2.size()){
            return !areEqual;
        } else{
            while(!stack1.empty() && check){
                CalendarDate s1 = stack1.pop();
                CalendarDate s2 = stack2.pop();
                temp.push(s1);
                temp.push(s2);
                if(s1.compareTo(s2) != 0){
                    areEqual = false;
                    check = false;
                }
            }
            while(!temp.empty()){
                stack2.push(temp.pop());
                stack1.push(temp.pop());
            }
        }
        return areEqual;
    }


    // Exercise #15 isSorted method below:
    public static boolean isSorted(Stack<CalendarDate> testAll){
        boolean check = true;
        boolean sorted = true;
        Stack<CalendarDate> temp = new Stack<CalendarDate>(); // create aux, storage

        if(testAll.size() == 0 || testAll.size() == 1){
            return sorted;
        } else{
            CalendarDate smallestNumber = testAll.pop();
            temp.push(smallestNumber);
            while(!testAll.empty() && check){
                CalendarDate s1 = testAll.pop();
                temp.push(s1);
                if(s1.compareTo(smallestNumber) != 1 || s1.compareTo(smallestNumber) != 0){
                    sorted = false;
                    check = false;
                }
            }
        }
        while(!temp.empty()){
            testAll.push(temp.pop());
        }
        return sorted;
    }


    //Exercise #19 removeMin below:
    public static Stack<CalendarDate> removeMin(Stack<CalendarDate> testAll){
        Queue<CalendarDate> q = new LinkedList<CalendarDate>(); // create aux. storage
        CalendarDate min = testAll.peek();

        while(!testAll.empty()){
            CalendarDate n = testAll.pop();
            q.add(n);
            if(n.compareTo(min) == -1){
                min = n;
            }
        }
        // found the smallest value

        // transfer all values except minimum back to the stack
        while(!q.isEmpty()){
            if(q.peek().compareTo(min) != 0){
                testAll.push(q.remove());
            } else{
                q.remove();
            }
        }

        while(!testAll.empty()){
            q.add(testAll.pop());
        }
        while(!q.isEmpty()){
            testAll.push(q.remove());
        }
        return testAll;
    }

}