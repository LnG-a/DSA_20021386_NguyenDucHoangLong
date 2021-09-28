import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.List;

public class SherlockAndArray {
    public static void main(String[] args) {
        In in = new In("D:\\E-Learning\\CTDLGT\\algs4-data\\32Kints.txt");
        int[] a = in.readAllInts();
        Integer[] spam = new Integer[] { 1, 2, 3 };
        List<Integer> list= Arrays.asList(spam);
        System.out.println(checkSum(list));
    }

    /**
     * This method check if there is a number that it's sum of left elements equal to the right one.
     *
     * @param arr an array of int
     * @return  YES if there is a number that it's sum of left elements equal to the right one
     *          NO if there is not.
     */
    public static String checkSum(List<Integer> arr) {
        long sumLeft = 0;
        long sumRight = 0;
        for (int i = 0; i < arr.size(); i++) {
            sumRight += arr.get(i);
        }
        for (int i = 0; i < arr.size(); i++) {
            sumRight -= arr.get(i);
            if (sumLeft == sumRight) return "YES";
            sumLeft += arr.get(i);
        }
        return "NO";
    }
}
