import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSortInPlace {
    public static void main(String[] args) {
        Scanner a= new Scanner(System.in);
        List<Integer> arr= new ArrayList<>();
        int n =a.nextInt();
        for (int i=0;i<n;i++){
            arr.add(a.nextInt());
        }
        quickSort(arr,0,arr.size()-1);
    }

    public static void quickSort (List<Integer> a, int low, int high){
        if (high>low){
            int pivot = a.get(high);
            int i=low;
            for (int j=low;j<high;j++){
                if (a.get(j)<pivot){
                    exchange(a,i,j);
                    i++;
                }
            }
            exchange(a,i,high);
            print(a);
            //System.out.println("low="+ a.get(low)+" high="+a.get(high));
            quickSort(a,low,i-1);
            quickSort(a,i+1,high);

        }

    }

    private static void exchange(List<Integer> a, int i, int j) {
        int exchange=a.get(j);
        a.set(j,a.get(i));
        a.set(i,exchange);
    }

    private static void print(List<Integer> a){
        for (int i=0;i<a.size();i++){
            System.out.print(a.get(i)+" ");
        }
        System.out.println();
    }
}
