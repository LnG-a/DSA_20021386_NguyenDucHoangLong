import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Node {
    public int data;
    public Node parent;
    public Node left;
    public Node right;

    // Các biến tạm dưới đây có thể dùng để lưu vị trí, kiểm tra nếu sinh viên thấy cần thiết
    public boolean tempBool1; // Hai biến tạm kiểu boolean có thể dùng cho bất kỳ mục đích gì
    public boolean tempBool2;
    public int tempInt1; // Hai biến tạm kiểu int có thể dùng cho bất kỳ mục đích gì
    public int tempInt2;
    public Node tempNode1; // Hai biến tạm kiểu Node có thể dùng cho bất kỳ mục đích gì
    public Node tempNode2;

    public Node(int data, Node parent, Node left, Node right) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    static public Node push(Node root, int n, int newValue){
        if (root == null) {
            root = new Node(newValue,null,null,null);
            return root;
        }
        else {
            Node a = findTheParent(root, 1,n);
            Node newNode = new Node(newValue,a,null,null);
            newNode.parent = a;
            if (a.left == null) a.left = newNode;
            else a.right = newNode;
            swim(newNode,root);
            return newNode;
        }
    }


    static private Node findTheParent(Node root, int index,int n) {
        if (root == null || index == (n + 1) / 2) return root;
        Node left = findTheParent(root.left, index * 2,n);
        Node right = findTheParent(root.right, index * 2 + 1,n);
        if (left != null) return left;
        else return right;
    }

    static public int getMax(Node root){
        if (root==null) return -1;
        return root.data;
    }

    static private void swim(Node newNode, Node root) {
        while (newNode != root) {
            if (newNode.data > newNode.parent.data) {
                swap(newNode, newNode.parent);
                newNode = newNode.parent;
            } else break;
        }
    }

    static private void swap(Node newNode, Node parent) {
        int a = newNode.data;
        newNode.data = parent.data;
        parent.data = a;
    }
}