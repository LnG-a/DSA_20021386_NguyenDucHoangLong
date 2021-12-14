import java.util.Scanner;

public class Main {
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length-1; i++) {
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

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int n=a.nextInt();
        a.next();
        int [] arr= new int[n];
        for (int i=0;i<n;i++){
            arr[i]=a.nextInt();
        }
        insertionSort(arr);
        for (int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
    }
}
