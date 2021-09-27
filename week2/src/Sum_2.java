import edu.princeton.cs.algs4.*;
import static java.util.Arrays.sort;

public class Sum_2 {
    public static void main(String[] args) {
        In in = new In("D:\\E-Learning\\CTDLGT\\algs4-data\\32Kints.txt");
        int[] a = in.readAllInts();
        sort(a);

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) break;
            if (i > 0 && a[i] == a[i - 1]) continue;
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < 0) break;
                if (a[j] < -a[i]) break;
                if (a[i] + a[j] == 0) {
                    StdOut.println(a[i] + " " + a[j]);
                    break;
                }
            }
        }
    }
}
//javac -cp D:\E-Learning\CTDLGT\algs4.jar;. Sum_2.java
//java -cp D:\E-Learning\CTDLGT\algs4.jar;. Sum_2
