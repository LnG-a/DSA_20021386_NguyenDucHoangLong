package week10;

public class IsThisABST {
    Node root;
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data= data;
        }
    }

    public int max(Node root) {
        if (root.right == null) return root.data;
        return max(root.right);
    }

    public int min(Node root) {
        if (root.left == null) return root.data;
        return min(root.left);
    }

    boolean checkBST(Node root) {
        if (root == null) return true;
        boolean requiredLeft = true;
        boolean requiredRight = true;
        if (root.left != null) requiredLeft = root.data > max(root.left);
        if (root.right != null) requiredRight = root.data < min(root.right);
        return requiredLeft && requiredRight && checkBST(root.left) && checkBST(root.right);
    }
    public static void main(String[] args) {
        IsThisABST a = new IsThisABST();
        a.root = new Node(1);
        a.root.right =new Node(2);
        a.root.right.left =new Node(4);
        a.root.right.right=new Node(3);
        System.out.println(a.checkBST(a.root));
    }
}
