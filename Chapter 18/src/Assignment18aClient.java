public class Assignment18aClient {

    public static void main(String[] args) {

        HashSet<CalendarDate> test = new HashSet<CalendarDate>();

        for (int i = 1; i < 16; i += 2) {

            test.add(new CalendarDate(7, i, 17));
        }
        test.add(new CalendarDate(7,22,17));
        System.out.println(test.toString2());
        System.out.println(test.backwards());
    }
}
