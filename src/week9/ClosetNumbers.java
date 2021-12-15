package week9;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class ClosetNumbers {

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        Integer[] a =new Integer[arr.size()];
        arr.toArray(a);
        mergeSort(a);

        int min=Integer.MAX_VALUE;
        for (int i=0;i<a.length-1;i++){
            int distance=a[i+1]-a[i];
            if (min> distance) {
                min =distance;
            }
        }

        List<Integer> result=new ArrayList<>();
        for (int i =0;i<a.length-1;i++){
            if (a[i+1]-a[i]==min){
                result.add(a[i]);
                result.add(a[i+1]);
            }
        }
        return result;
    }
    public static void mergeSort(Integer[] a) {
        Integer[] aux = new Integer[a.length];
        sort(a, aux, 0, a.length - 1);

    }

    private static void sort(Integer[] a, Integer[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Integer[] a, Integer[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
