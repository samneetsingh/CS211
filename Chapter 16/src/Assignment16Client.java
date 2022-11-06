public class Assignment16Client {
    public static void main(String[] args) {
        LinkedList<String> A = new LinkedList<String>();
        LinkedList<Integer> B = new LinkedList<Integer>();
        A.stutter();
        System.out.println(A.toString());  //[1, 1, 19, 19, 4, 4, 17, 17, 23, 23, 25, 25, 82, 82, 28, 28]
        // A.removeAll("4");
        System.out.println(A); // [1, 1, 19, 19, 17, 17, 23, 23, 25, 25, 82, 82, 28, 28]
        // A.deleteBack();
        // System.out.println(A); // [1, 1, 19, 19, 17, 17, 23, 23, 25, 25, 82, 82, 28]
        A.switchPairs();
        System.out.println(A); // [1, 1, 19, 19, 17, 17, 23, 23, 25, 25, 82, 82, 28]
        System.out.println(A.backwards());
    }
}
