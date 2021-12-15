package week7;

import java.util.List;

public class FindTheMedian {
    public static int findMedian(List<Integer> arr) {
        // Write your code here
        quickSort(arr,0,arr.size()-1);
        return arr.get(arr.size()/2);
    }

    private static int find (List<Integer> a, int low, int high){
        if (high>low){
            int pivot = a.get(high);
            int i=low;
            for (int j=low;j<high;j++){
                if (a.get(j)<pivot){
                    exchange(a,i,j);
                    i++;
                }
            }
            exchange(a,i,high);
            if (i<a.size()/2) return find(a, low, i - 1);
            else if (i>a.size()/2) return find(a, i + 1, high);
            else return i;
        }
        return high;
    }

    private static void exchange(List<Integer> a, int i, int j) {
        int exchange=a.get(j);
        a.set(j,a.get(i));
        a.set(i,exchange);
    }

    public static void quickSort (List<Integer> a, int low, int high){
        if (high>low){
            int pivot = a.get(high);
            int i=low;
            for (int j=low;j<high;j++){
                if (a.get(j)<pivot){
                    exchange(a,i,j);
                    i++;
                }
            }
            exchange(a,i,high);
            quickSort(a,low,i-1);
            quickSort(a,i+1,high);
        }
    }
}
