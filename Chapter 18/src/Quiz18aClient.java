public class Quiz18aClient {
    public static void main(String[] q65) {
        HashSet<Integer> test = new HashSet<Integer>();
        test.add(1); test.add(2); test.add(3); test.add(65);  test.add(422);test.add(516);test.add(3287);
        System.out.println(test); // [1, 2, 3, 65, 422]
        System.out.println(test.backwards()); // above in reverse order

        test.add(13);  test.add(23);  test.add(33); // forcing collisions
        System.out.println(test.toString()); // more data
        //System.out.println(test.toString2()); // to see chained hashing
        System.out.println(test.backwards()); // reverse order
    }

}
