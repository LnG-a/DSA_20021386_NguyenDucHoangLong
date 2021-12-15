package week7;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> a= new ArrayList<>();
        for (int i=0;i<10;i++){
            a.add(10-i);
        }
        quickSort(a,0,a.size()-1);
        print(a);
    }

    private static int find (List<Integer> a, int low, int high){
        if (high>low&&high<a.size()){
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
            if (i<a.size()/2) return find(a, low, i - 1);
            else if (i>a.size()/2) return find(a, i + 1, high);
            else return i;
        }
        return high;
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
