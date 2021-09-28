import edu.princeton.cs.algs4.In;

import java.util.*;

public class ClosestNumber {
    public static void main(String[] args) {
        In in = new In("D:\\E-Learning\\CTDLGT\\algs4-data\\32Kints.txt");
        int[] a = in.readAllInts();
        List<Integer> arr = new ArrayList<>();
        List<Integer> pairs = closestPair(arr);
        for (int i = 0; i < pairs.size(); i += 2) {
            System.out.println(pairs.get(i) + " " + pairs.get(i + 1));
        }
    }

    /**
     * This method finds pairs of numbers which have the smallest absolute difference.
     *
     * @param arr an array of int
     * @return list of pairs
     */
    public static List<Integer> closestPair(List<Integer> arr) {
        Collections.sort(arr);
        List<Integer> list = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            int value = Math.abs(arr.get(i) - arr.get(i+1));
            if (min > value) {
                min = value;
            }
        }
        for (int i = 0; i < arr.size() - 1; i++) {
            if (Math.abs(arr.get(i) - arr.get(i+1)) == min) {
                list.add(arr.get(i));
                list.add(arr.get(i+1));
            }
        }
        return list;
    }
}
