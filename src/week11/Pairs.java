package week11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        int count = 0;
        HashSet<Integer> set = new HashSet<>(arr);
        for (int i : arr) {
            int sub = i + k;
            if (set.contains(sub)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(6);
        list.add(4);
        list.add(2);
        System.out.println(pairs(2, list));
    }
}
