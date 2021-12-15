package week11;

import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class Bai3 {
    public static void main(String[] args) {
        LinearProbingHashST<Integer, Integer> hashST = new LinearProbingHashST<>(17);
        int i = 0;
        hashST.put(3, i++);
        hashST.put(13, i++);
        hashST.put(6, i++);
        hashST.put(7, i++);
        hashST.put(23, i++);
        hashST.put(16, i++);
        hashST.put(33, i++);
        System.out.println(hashST.get(6));
        System.out.println(hashST.get(33));
        System.out.println(hashST.get(40));

        SeparateChainingHashST<Integer, Integer> hashST1 = new SeparateChainingHashST<>(17);
        i = 0;
        hashST1.put(3, i++);
        hashST1.put(13, i++);
        hashST1.put(6, i++);
        hashST1.put(7, i++);
        hashST1.put(23, i++);
        hashST1.put(16, i++);
        hashST1.put(33, i++);
        System.out.println(hashST1.get(6));
        System.out.println(hashST1.get(33));
        System.out.println(hashST1.get(40));
    }
}
