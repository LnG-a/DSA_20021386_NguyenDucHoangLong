import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formattable;
import java.util.List;

public class ClosestNumber {
    public static void main(String[] args) {
        In in = new In("D:\\E-Learning\\CTDLGT\\algs4-data\\32Kints.txt");
        int[] a = in.readAllInts();
        List<Integer> pairs = closestPair(a);
        for (int i = 0; i < pairs.size(); i += 2) {
            System.out.println(pairs.get(i) + " " + pairs.get(i + 1));
        }
    }

    /**
     * This method finds pairs of numbers which have the smallest absolute difference.
     *
     * @param a an array of int
     * @return list of pairs
     */
    public static List<Integer> closestPair(int[] a) {
        Arrays.sort(a);
        List<Integer> list = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            int value = Math.abs(a[i] - a[i + 1]);
            if (min > value) {
                min = value;
            }
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (Math.abs(a[i] - a[i + 1]) == min) {
                list.add(a[i]);
                list.add(a[i + 1]);
            }
        }
        return list;
    }
}
