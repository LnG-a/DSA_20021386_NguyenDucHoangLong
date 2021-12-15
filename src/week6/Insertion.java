package week6;

import java.util.List;

public class Insertion {
    public static void insertionSort1(int n, List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            int value = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > value) {
                arr.set(j+1,arr.get(j));
                print(arr);
                System.out.println();
                j = j - 1;
            }
            arr.set(j+1,value);
        }

    }

    public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (arr.get(j) < arr.get(j-1)) {
                    exchange(arr, j, j - 1);

                } else {
                    break;
                }
            }
            print(arr);
        }
    }

    private static void exchange(List<Integer> a, int i, int j) {
        int exchange = a.get(i);
        a.set(i,a.get(j));
        a.set(j,exchange);
    }

    private static void print(List<Integer> a){
        for(int k=0;k<a.size();k++){
            System.out.print(a.get(k)+" ");
        }
        System.out.println();
    }
}
