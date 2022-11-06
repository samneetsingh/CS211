public class Quiz16Client {
    public static void main(String[] args) {
        LinkedList<Integer> quiz16 = new LinkedList<Integer>();
        LinkedList<String> quizz16 = new LinkedList<String>();

        /* System.out.println(quizz16.isPerfectMirror()); // false
        quizz16.add("Hello"); quizz16.add("Miss"); quizz16.add("Aruna");
        quizz16.add("Aruna"); quizz16.add("Miss"); quizz16.add("Hello");
        System.out.println(quizz16); // [Hello, Miss, Aruna, Aruna, Miss, Hello]
        System.out.println(quizz16.isPerfectMirror()); // true
        quizz16.undoMirror();
        System.out.println(quizz16); // [Hello, Miss, Aruna] */

        System.out.println(quiz16.isPerfectMirror()); // false
        quiz16.add(1); quiz16.add(1); quiz16.add(2); quiz16.add(2);
        quiz16.add(3); quiz16.add(3); quiz16.add(3); quiz16.add(3);
        System.out.println(quiz16); // [1, 2, 3, 3, 2, 1]
        System.out.println(quiz16.returnNumDuplicates(2));
        quiz16.removeDuplicates();
        System.out.println(quiz16);
        System.out.println(quiz16.isPerfectMirror()); // true
        quiz16.undoMirror();
        System.out.println(quiz16); // [1, 2, 3]
    }
}
