import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pairs {
    public static void main(String[] args) {
        In in = new In("D:\\E-Learning\\CTDLGT\\algs4-data\\32Kints.txt");
        int[] a = in.readAllInts();
        System.out.println(pairs(a,1));
    }

    /**
     * This method find the number of pairs that have certain absolute difference.
     *
     * @param a the array of int
     * @param k the number which are absolute difference of 2 element
     * @return
     */
    public static int pairs(int[] a,int k) {
        int dem=0;
        Arrays.sort(a);
        for (int i=0;i<a.length-1;i++){
            if (Math.abs(a[i]-a[i+1])==k){
                dem++;
            }
        }
        return dem;
    }
}
