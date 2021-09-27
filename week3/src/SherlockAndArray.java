import edu.princeton.cs.algs4.In;

public class SherlockAndArray {
    public static void main(String[] args) {
        In in = new In("D:\\E-Learning\\CTDLGT\\algs4-data\\32Kints.txt");
        int[] a = in.readAllInts();
        System.out.println(checkCriterion(a));
    }

    public static String checkCriterion(int[] a) {
        long sumLeft = 0;
        long sumRight = 0;
        for (int i = 0; i < a.length; i++) {
            sumRight += a[i];
        }
        for (int i = 0; i < a.length; i++) {
            sumRight -= a[i];
            if (sumLeft == sumRight) return "YES";
            sumLeft += a[i];
        }
        return "NO";
    }
}
