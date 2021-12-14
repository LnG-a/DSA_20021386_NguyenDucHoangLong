import java.util.ArrayList;
import java.util.List;

public class CountingSort1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            a.add(0);
        }
        for (int i = 0; i < arr.size(); i++) {
            a.set(arr.get(i), a.get(arr.get(i)) + 1);
        }
        return a;
    }
}