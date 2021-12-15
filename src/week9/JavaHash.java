package week9;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHash {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        Set check = new HashSet();
        int count = 0;
        for (int i = 0; i < t; i++) {
            int size = check.size();
            check.add(pair_left[i]+" "+pair_right[i]);
            if (size == check.size() - 1) {
                count++;
            }
            System.out.println(count);
        }
    }
}
