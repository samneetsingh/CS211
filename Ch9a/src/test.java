import java.util.ArrayList;

public class test extends Quiz10 {
    public static void main(String[] a402) {
        ArrayList<CalendarDate> dates = new ArrayList<CalendarDate>(247);
        dates.add(new CalendarDate(5, 5, 2018));
        dates.add(new CalendarDate(10, 5, 2018));
        dates.add(new CalendarDate(5, 7, 2017));
        dates.add(new CalendarDate(10, 5, 2020));
        System.out.println("Before: " + dates); // 4 items in list
        doubleMayDates(dates);
        System.out.println(" After: " + dates); // now 6 items in list
    }
}
