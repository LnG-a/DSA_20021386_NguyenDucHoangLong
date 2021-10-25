import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Sort {
    public static void main(String[] args) {
        In myIn = new In("100kAscending.txt");
        In myIn1 = new In("100kDescending.txt");
        In myIn2 = new In("100kRandom.txt");
        In myIn3 = new In("100kFewUnique.txt");
        long start;
        long end;
        double tong=0;

        int[] a = myIn.readAllInts();
        int[] b=new int[a.length];
        int n =5;
        for (int j=0;j<n;j++){
            for (int i=0;i<a.length;i++){
                b[i]=a[i];
            }
            start = System.currentTimeMillis();
            quickSort(b);
            end = System.currentTimeMillis();
            tong+=(end-start);
        }
        System.out.println(tong/n+"ms");
    }

    /**
     * Complexity O(N^2).
     * No worst case or best case.
     *
     * @param a int array
     */
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[min] > a[j]) min = j;
            }
            exchange(a, i, min);
        }
    }

    /**
     * Complexity O(N^2).
     * Space: 2*N.
     * Worst case: Reversed Sorted Array.
     * Best case: Sorted Array (N-1).
     *
     * @param a int array
     */
    public static void insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    exchange(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void exchange(int[] a, int i, int j) {
        int exchange = a[i];
        a[i] = a[j];
        a[j] = exchange;
    }

    /**
     * Complexity O(NlogN)
     * No worst case or best case
     *
     * @param a int array
     */
    public static void mergeSort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);

    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
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

    /**
     * Complexity average O(NlogN)
     * Worst case: Sorted Array: O(N^2)
     * Best case: Pivot is in middle of array O(NlogN)
     *
     * @param a int array
     */
    public static void quickSort(int[] a) {
        StdRandom.shuffle(a);
        //sort(a, 0, a.length - 1);
        partition(a,0,a.length-1);
    }

    private static int partition(int[] a, int lo, int hi) {
        if (hi<=lo) return hi;
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (a[++i] < a[lo]) {
                if (i == hi) break;
            }
            while (a[--j] > a[lo]) {
                if (j == lo) break;
            }

            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        partition(a, lo, j - 1);
        partition(a, j + 1, hi);
        return j;
    }
}
/*
* Time (ms)
*
*       |           |Selection sort |Insertion sort |  Merge sort   |  Quick sort   |
* data  |   type    |               |               |               |               |
* 1k    |Ascending  |     4.6       |     0.0       |     0.4       |     2.6       |
*       |Descending |     5.2       |     9.8       |     0.6       |     2.8       |
*       |Random     |     4.4       |     4.6       |     1.0       |     3.4       |
*       |FewUnique  |     5.2       |     5.8       |     0.8       |     3.0       |
* -----------------------------------------------------------------------------------
* 32k   |Ascending  |    136.6      |     1.2       |     8.0       |    16.4       |
*       |Descending |    721.4      |    392.2      |     7.2       |    15.0       |
*       |Random     |    392.4      |    195.2      |     5.6       |     6.6       |
*       |FewUnique  |    404.2      |    193.6      |     6.4       |     6.8       |
* -----------------------------------------------------------------------------------
* 100k  |Ascending  |    1199.4     |     2.0       |     7.0       |    16.8       |
*       |Descending |    3836.6     |    3558.0     |     7.4       |    18.0       |
*       |Random     |    4159.4     |    1786.6     |    15.4       |    16.2       |
*       |FewUnique  |    4177.2     |    1766.8     |    15.0       |    14.8       |
* -----------------------------------------------------------------------------------
*
* Quicksort without shuffle will lead to StackOverFlow with data:
* - about 16570 int ascending
* - about 16000 int descending
*/
