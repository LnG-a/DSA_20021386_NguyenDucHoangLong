import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int min = 0;
        int max = 20;
        int n = Integer.parseInt(args[0]);
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) Math.floor(Math.random() * (max - min + 1) + min);
            System.out.println("a[" + i + "]=" + a[i]);
        }
        Arrays.sort(a);
        int number = (int) Math.floor(Math.random() * (max - min + 1) + min);
        if (binarySearch(a, number) == -1) {
            System.out.println("Khong tim thay " + number + " trong day");
        } else {
            System.out.printf("vi tri cua so %d la: %d%n", number, binarySearch(a, number));
        }
    }

    /**
     * This method is used to find index of a number in an array.
     *
     * @param a      an array of int in ascending order
     * @param number an int variable that you want to find
     * @return the index of the number in array a
     */
    public static int binarySearch(int[] a, int number) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int i = low + (high - low) / 2;
            if (number > a[i]) {
                low = i + 1;
            } else if (number < a[i]) {
                high = i - 1;
            } else {
                return i;
            }
        }
        return -1;
    }
}
