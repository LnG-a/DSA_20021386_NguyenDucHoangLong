import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pairs {
    public static void main(String[] args) {
        In in = new In("D:\\E-Learning\\CTDLGT\\algs4-data\\4Kints.txt");
        int[] a = in.readAllInts();
        List<Integer> list= new ArrayList<>();
        for (int j : a) {
            list.add(j);
        }
        System.out.println(pairs(list,0));
    }

    /**
     * This method find the number of pairs that have certain absolute difference.
     * Complexity O(N)
     *
     * @param arr the list of Integer
     * @param k   the number which are absolute difference of 2 element
     * @return    the number of pairs
     */
    public static int pairs(List<Integer> arr, int k) {
        Collections.sort(arr);
        int dem = 0;
        int left = 0;
        int right = 1;
        while (right < arr.size()) {
            if (left == right){
                if (right < arr.size() - 1) {
                    right++;
                }else {
                    break;
                }
            }
            int diff = arr.get(right) - arr.get(left);
            if (diff == k) {
                dem++;
                right++;
            } else if (diff > k) {
                left++;
            } else {
                right++;
            }
        }
        return dem;
    }

    /**
     * This method find the number of pairs that have certain absolute difference.
     * Complexity O(N^2/2)
     *
     * @param arr the list of Integer
     * @param k   the number which are absolute difference of 2 element
     * @return    the number of pairs
     */
    public static int pairs2(List<Integer> arr,int k) {
        int dem=0;
        for (int i=0;i<arr.size()-1;i++){
            for (int j=i+1;j<arr.size();j++) {
                if (Math.abs(arr.get(i) - arr.get(j)) == k) {
                    dem++;
                }
            }
        }
        return dem;
    }


}
