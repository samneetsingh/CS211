import java.util.ArrayList;

/*
Samneet Singh
Computer Science 211
01/20/2020
A program that checks for may dates and then inserts them twice
*/
public class Quiz10 extends CalendarDate {

    // create method doubleMayDates
    public static ArrayList<CalendarDate> doubleMayDates(ArrayList<CalendarDate> dates) {

        // create a duplicate arraylist to work within
        ArrayList<CalendarDate> newArrayList = new ArrayList<CalendarDate>();

        // create values to store the size of the array and calendar dates
        int arraySize = dates.size();
        CalendarDate monthOfDate = new CalendarDate();

        // return null if the array is empty
        if (arraySize == 0) {
            return null;
        }
        else {

            // create a for loop that adds the monthOfDate the needed number of times to the new array
            for (int i = 0; i < arraySize; i++) {

                monthOfDate = dates.get(i);

                if (monthOfDate.getMonth() == 5) {

                    for (int j = 0; j < 2; j++) {
                        newArrayList.add(monthOfDate);
                    }

                }
                else {
                    // if not just add the normal number
                    newArrayList.add(monthOfDate);

                }
            }

        }
        // clear the original array
        dates.clear();

        // set the value to the newArrayList
        dates = newArrayList;

        // print the arrays
        System.out.println(newArrayList);
        System.out.println(dates);

        // return the array
        return dates;
    }

}
