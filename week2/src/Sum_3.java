import edu.princeton.cs.algs4.*;
import static java.util.Arrays.sort;


public class Sum_3 {
    public static void main(String[] args) {
        In in = new In("D:\\E-Learning\\CTDLGT\\algs4-data\\32Kints.txt");
        int[] a = in.readAllInts();
        findTriplets(a,a.length);
    }

    static void findTriplets(int[] arr, int n)
    {
        boolean found = false;

        sort(arr);

        for (int i=0; i<n-1; i++)
        {
            while (i>0&&arr[i]==arr[i-1]) {
                i++;
                continue;
            }
            int l = i + 1;
            int r = n - 1;
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
//javac -cp D:\E-Learning\CTDLGT\algs4.jar;. Sum_3.java
//java -cp D:\E-Learning\CTDLGT\algs4.jar;. Sum_3
