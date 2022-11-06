/* CS211 Fibonacci Class, for Chapter 12 Assignment
 * Bellevue College, W.P. Iverson, instructor
 * January 2020
 */
public class FibDrive {
    public static void main(String[] args) {
        Fibonacci test = new Fibonacci(40); // only needed for overload
        System.out.println(test.fibForLoop()); // slow version in text   
        System.out.println(test.fibonacci()); // slow version in text 
        System.out.println(test.bigFib()); // same as above, but use BigIntegers
        System.out.println(test.bigFastFib()); // same as above, but MUCH faster
    }
}