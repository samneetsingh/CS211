/* CS211 Fibonacci Class, for Chapter 13 Assignment
 * Bellevue College, Samneet Singh
 * Feb 8th, 2021
 * The purpose of this is to do research and run tests to calculate the big-o value of the slow and fast fibonacci methods
 * I personally added a for loop in order to test several values of fibonacci at once so that I could analyze and factor
 * all of the data at once. Feel free to remove my tester ui. I'm leaving it in just so you can see how I analyzed the data
 * */
import java.util.*;

public class FibDriver {
    // copyright Bellevue College
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Up to what fib number should we calculate? (Only goes up to 45 because more than that crashes computer)");
        int entered = keyboard.nextInt();
        if (entered <= 45) {
        // adding a for loop here (I know it will increase the run time dramatically but it allows me to do many test runs)
            for (int x = 1; x <= entered; x++) {
                Fibonacci test = new Fibonacci(x); // constructor overload
                //System.out.println(test.fibForLoop()); // Chapter 2 code not used this week
                long time1 = System.currentTimeMillis();
                System.out.println(test.fibonacci()); // slow version in text
                long time2 = System.currentTimeMillis();
                System.out.println("slow version run time ms: " + (time2 - time1));
                System.out.println();
                // After testing every number from 0 to 44 and doing some research: (Comments explaining how I reached my answers above)
                // I conclude that fibonacci() is very slow with Big-O complexity of *****O(2^N)*****

                time1 = System.currentTimeMillis();
                //System.out.println(test.bigFib()); // same as above, but use BigIntegers
                System.out.println(test.bigFastFib()); // same as above, but MUCH faster
                time2 = System.currentTimeMillis();
                System.out.println("bigFastFib version run time ms: " + (time2 - time1));
                // After testing tons of numbers even going as far as N 70+ (was scared to do more for my computer's sake):
                // I conclude that bigFastFib() is very fast with Big-O complexity of *****O(N)*****
            }
        }
        else {
            System.out.println("Please pick a smaller number so this doesn't completely annihilate my computer!");
        }
    }
}
