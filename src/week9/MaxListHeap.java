package week9;

import java.util.ArrayList;
import java.util.List;

public class MaxListHeap {
    private List<Integer> a = new ArrayList<>();

    MaxListHeap() {
        a.add(0);
    }

    public void insert(int Key) {
        a.add(Key);
        swim(a.size() - 1);
    }

    public int del() {
        int max = a.get(1);
        a.set(1, a.get(a.size() - 1));
        a.remove(a.size() - 1);
        sink(1);
        return max;
    }

    public int peak(){
        return a.get(1);
    }

    public int size(){
        return a.size();
    }

    private void sink(int index) {
        while (index * 2 <= a.size() - 1) {
            int j = index * 2;
            if (j + 1 <= a.size() - 1 && a.get(j + 1) > a.get(j)) j++;
            if (a.get(index) > a.get(j)) break;
            exchange(index, j);
            index = index * 2;
        }
    }

    private void swim(int index) {
        while (index > 1 && a.get(index) > a.get(index / 2)) {
            exchange(index, index / 2);
            index = index / 2;
        }
    }

    private void exchange(int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }
}