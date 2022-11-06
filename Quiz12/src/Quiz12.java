/*
Samneet Singh
Computer Science 211
02/03/2021
Write a method that removes adjacent duplicate characters and returns the string properly
*/
public class Quiz12 {
    // copyright Bellevue College
    public static void main(String[] x961) {
        System.out.println(removeDupChars("bookkkkkeeper"));
        System.out.println(removeDupChars("String"));
        System.out.println(removeDupChars(""));
    }

    public static String removeDupChars(String str) {
        // create an if statement to make sure the string needs to be run recursively
        if (str.length() <= 1) {

            return str;

        }
        // compare the first character and the second character of the string
        if (str.substring(1, 2).equals(str.substring(0, 1))) {

            // return everything but the repeated character
            return removeDupChars(str.substring(1));

        // if characters are not equivalent they may be added together
        } else {

            return str.substring(0, 1) + removeDupChars(str.substring(1));

        }
    }
}