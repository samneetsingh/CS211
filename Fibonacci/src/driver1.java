import java.util.*;

public class driver1 {
    public static void main(String[] args) {

        int[] list = new int[10000];

        for (int x = 0; x < list.length; x++) {

            list[x] = x;

        }

        long time1 = System.currentTimeMillis();
        mystery1(list);
        long time2 = System.currentTimeMillis();

        System.out.print(time2 - time1);
    }

    public static String mystery1(int[] list) {

        return list.toString();

    }
}