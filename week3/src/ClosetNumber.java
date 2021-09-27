import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class ClosetNumber {
    public static void main(String[] args) {
        In in = new In("D:\\E-Learning\\CTDLGT\\algs4-data\\32Kints.txt");
        int[] a = in.readAllInts();
        closetPair(a);
    }

    public static void closetPair(int[] a) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        int pos = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int value = Math.abs(a[i] - a[i + 1]);
            if (min > value) {
                pos = i;
                min = value;
            }
            if (min == 0) {
                System.out.println(a[i] + " " + a[i + 1]);
                return;
            }
        }
        System.out.println(a[pos] + " " + a[pos + 1]);
    }
}