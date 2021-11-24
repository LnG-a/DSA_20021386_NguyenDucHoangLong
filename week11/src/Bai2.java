
import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.MaxPQ;

public class Bai2 {
    public static void main(String[] args) {
        MaxPQ<Integer> maxHeap = new MaxPQ<>();
        maxHeap.insert(1);
        maxHeap.insert(3);
        maxHeap.insert(10);
        maxHeap.insert(9);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(8);
        for (int i = 0; i < 4; i++) System.out.println(maxHeap.delMax());

        BST<Integer, Integer> bst = new BST<>();
        int i = 0;
        bst.put(1, i++);
        bst.put(3, i++);
        bst.put(10, i++);
        bst.put(9, i++);
        bst.put(6, i++);
        bst.put(7, i++);
        bst.put(4, i++);
        bst.put(5, i++);
        bst.put(2, i++);
        bst.put(8, i++);
        bst.delete(3);
        bst.delete(5);
        bst.delete(7);
        bst.delete(9);

    }
}
