import edu.princeton.cs.algs4.In;

public class SherlockAndArray {
    public static void main(String[] args) {
        In in = new In("D:\\E-Learning\\CTDLGT\\algs4-data\\32Kints.txt");
        int[] a = in.readAllInts();
        System.out.println(checkSum(a));
    }

    /**
     * This method check if there is a number that it's sum of left elements equal to the right one.
     *
     * @param a an array of int
     * @return  YES if there is a number that it's sum of left elements equal to the right one
     *          NO if there is not.
     */
    public static String checkSum(int[] a) {
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
