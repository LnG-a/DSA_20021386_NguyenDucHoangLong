package week8;

import java.util.List;
import java.util.PriorityQueue;

public class JesseAndCookies {
    public static void main(String[] args) {
        PriorityQueue<Integer> a = new PriorityQueue<>();
        a.add(2);
        a.add(3);
        a.add(1);
        a.add(4);
        System.out.println(a.peek());
        System.out.println(Integer.MAX_VALUE);
    }

    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> a = new PriorityQueue<>();
        a.addAll(A);
        int count = 0;
        while (a.peek() < k) {
            if (a.size() == 1) return -1;
            a.add(a.poll() + a.poll() * 2);
            count++;
        }
        return count;
    }
}
