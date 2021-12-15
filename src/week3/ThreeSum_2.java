package week3;

import edu.princeton.cs.algs4.*;
import static java.util.Arrays.sort;

public class ThreeSum_2 {
    public static void main(String[] args) {
        In in = new In("D:\\E-Learning\\CTDLGT\\algs4-data\\32Kints.txt");
        int[] a = in.readAllInts();
        findTriplets(a);
    }

    /**
     * This method finds all three sum-equal-0 numbers.
     * Complexity O(N^2)
     * @param arr an int array
     */
    static void findTriplets(int[] arr)
    {
        boolean found = false;
        sort(arr);
        for (int i=0; i< arr.length-1; i++)
        {
            int l = i + 1;
            int r = arr.length - 1;
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == 0) {
                    System.out.print(x + " ");
                    System.out.print(arr[l] + " ");
                    System.out.println(arr[r] + " ");
                    l++;
                    r--;
                    found = true;
                } else if (x + arr[l] + arr[r] < 0) l++;
                else r--;
            }
        }
        if (!found)
            System.out.println(" No Triplet Found");
    }
}