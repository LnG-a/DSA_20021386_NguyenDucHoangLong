package week5;

import edu.princeton.cs.algs4.In;

public class SelectionSort {
    public static int[] selectionSort(int[] arr){
        for (int i=0;i<arr.length;i++) {
            int min=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[min]>arr[j]) min=j;
            }
            int change=arr[i];
            arr[i]=arr[min];
            arr[min]=change;
        }
        return arr;
    }

    public static void main(String[] args) {
        In in = new In("D:\\E-Learning\\CTDLGT\\algs4-data\\32Kints.txt");
        int[] a = in.readAllInts();
        long start = System.currentTimeMillis();
        selectionSort(a);
        long end = System.currentTimeMillis();
        for (int i=0;i<a.length;i+=10){
            for (int j=i;j<=i+10&&j<a.length;j++) {
                System.out.print(a[j]+" ");
            }
            System.out.println();
        }
        System.out.println(end-start);
    }
}
