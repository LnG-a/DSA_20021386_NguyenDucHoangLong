import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pairs {
    public static void main(String[] args) {
        In in = new In("D:\\E-Learning\\CTDLGT\\algs4-data\\4Kints.txt");
        int[] a = in.readAllInts();
        List<Integer> list=new ArrayList<Integer>();
        for (int i=0;i<a.length;i++){
            list.add(a[i]);
        }
        System.out.println(pairs(list,1));
    }

    /**
     * This method find the number of pairs that have certain absolute difference.
     *
     * @param arr the list of Integer
     * @param k   the number which are absolute difference of 2 element
     * @return
     */
    public static int pairs(List<Integer> arr,int k) {
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
