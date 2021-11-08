public class MaxTreeHeap {
    private Node root;
    private int size = 0;

    private static class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        Node(int value) {
            this.value = value;
        }
    }

    public void insert(int number) {
        if (root == null) root = new Node(number);
        else {
            Node a = findTheParent(root, 1);
            Node newNode = new Node(number);
            newNode.parent = a;
            if (a.left == null) a.left = newNode;
            else a.right = newNode;
            swim(newNode);
        }
        size++;
    }

    public int del() {
        int max = root.value;
        Node a= findTheLastNode(root, 1);
        root.value=a.value;
        if (a.parent.left==a) a.parent.left=null;
        else a.parent.right=null;
        sink(root);
        size--;
        return max;
    }

    private Node findTheLastNode(Node root, int index) {
        if (root == null || index == size) return root;
        Node left = findTheLastNode(root.left, index * 2);
        Node right = findTheLastNode(root.right, index * 2 + 1);
        if (left != null) return left;
        else return right;
    }

    private void sink(Node root) {
        if (root == null) return;
        if (root.left == null) return;
        if (root.right==null) {
            if (root.value>root.left.value) return;
            swap(root, root.left);
            return;
        }
        if (root.value>root.left.value&&root.value>root.right.value) return;
        if (root.left.value > root.right.value) {
            swap(root, root.left);
            sink(root.left);
        } else {
            swap(root, root.right);
            sink(root.right);
        }
    }

    public int peak() {
        return root.value;
    }

    public int size(){
        return size;
    }

    private void swim(Node newNode) {
        while (newNode.parent != null) {
            if (newNode.value > newNode.parent.value) {
                swap(newNode, newNode.parent);
                newNode = newNode.parent;
            } else break;
        }
    }

    private void swap(Node newNode, Node parent) {
        int a = newNode.value;
        newNode.value = parent.value;
        parent.value = a;
    }

    private Node findTheParent(Node root, int index) {
        if (root == null || index == (size + 1) / 2) return root;
        Node left = findTheParent(root.left, index * 2);
        Node right = findTheParent(root.right, index * 2 + 1);
        if (left != null) return left;
        else return right;
    }

    public void print(){
        this.print(root);
    }

    private void print(Node root) {
        if (root == null) return;
        System.out.print(" (");
        print(root.left);
        System.out.print(root.value);
        print(root.right);
        System.out.print(") ");
    }

    /*public static void main(String[] args) {
        MaxTreeHeap a = new MaxTreeHeap();
        for (int i = 0; i < 10; i++) {

            a.insert(i);
            print(a.root);
            System.out.println();
        }
        System.out.println(a.del());
        print(a.root);
        System.out.println();
        System.out.println(a.del());
        print(a.root);
    }*/
}