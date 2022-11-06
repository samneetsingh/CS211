/*
Samneet Singh
01/27/2021
Computer Science 211
To create a method that counts the mode of the given list using a map as auxillary storage

 */
import java.util.*;

public class Quiz11 {

    public static void main(String[] args297) {


        ArrayList<CalendarDate> list1 = new ArrayList<CalendarDate>(794);
        System.out.println(maxYearOccurrences(list1)); //   0 is returned when list is empty
        list1.add(new CalendarDate(5, 5, 2018));
        list1.add(new CalendarDate(1, 2, 2018));
        list1.add(new CalendarDate(5, 5, 2018));
        list1.add(new CalendarDate(10, 7, 1907));
        list1.add(new CalendarDate(5, 5, 2018));


        System.out.println(maxYearOccurrences(list1)); //   4 times we have the year 2018

    }

    // solutions go below here:

    public static int maxYearOccurrences(List<CalendarDate> inputList) {

        // create a new hashmap to store our list
        Map<Integer, CalendarDate> datavalues = new HashMap<>();
        // create a max count variable
        int maxCount = 0;
        // create a for each loop to store the list within a map
        for (CalendarDate date : inputList) {

            datavalues.put(inputList.indexOf(date), date);

        }
        // use a nested for loop to find the mode of the map
        for (int i = 0; i < inputList.size(); i++) {
            // create a resetting counter variable
            int count = 0;
            for (int j = 0; j < inputList.size(); ++j) {
                // create an if statement that checks how many times each value is seen
                if (datavalues.get(j) == datavalues.get(i)) {
                    ++count;
                }
            }
            // update the counter
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
}
