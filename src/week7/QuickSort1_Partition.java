import java.util.ArrayList;
import java.util.List;

public class QuickSort1_Partition {
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        int pivot=arr.get(0);
        for(int i =1 ;i<arr.size();i++){
            if (arr.get(i)<pivot) left.add(arr.get(i));
            else right.add(arr.get(i));
        }
        left.add(pivot);
        for (int i=0;i<right.size();i++){
            left.add(right.get(i));
        }
        return left;
    }
}
