import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    static class Node {
        int data;
        boolean visited;
        Node parent;
        List<Node> children;

        public Node(int data, Node parent, List<Node> children) {
            this.data = data;
            this.parent = parent;
            this.children = children;
            this.visited = false;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    static void insertNode(Node root, int parent, int newInt) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.data == parent) {
                temp.children.add(new Node(newInt, temp, new ArrayList<>()));
                break;
            }
            if (temp.children!=null) {
                for (Node i : temp.children) {
                    queue.add(i);
                }
            }
        }

    }

    static void delete(Node root, int key) {
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp= queue.poll();
            if (temp.data==key){
                if (temp.children.size()>0) {
                    temp.data = temp.children.get(root.children.size() - 1).data;
                    temp.children.remove(root.children.size() - 1);
                    break;
                } else temp=null;
                return;
            }
            for (Node i:temp.children){
                queue.add(i);
            }
        }
    }

    static boolean isBinaryTree(Node root) {
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp= queue.poll();
            if (temp.children.size()>2){
                return false;
            }
            for (Node i:temp.children){
                queue.add(i);
            }
        }
        return true;
    }

    static boolean isBinarySearchTree(Node root) {
        if (root==null) return  true;
        if (root.children.size()>2) return false;
        if (root.children.size()==0||root.children==null) return true;
        else if (root.children.size()==1) return root.children.get(0).data< root.data && isBinarySearchTree(root.children.get(0));
        else return root.children.get(0).data<root.data
                    && root.children.get(1).data> root.data
                    && isBinarySearchTree(root.children.get(0))
                    && isBinarySearchTree(root.children.get(1));
    }

    static boolean isMaxBinaryHeap(Node root) {
        if (root==null) return true;
        if (root.children.size()>2) return false;
        if (root.children.size()==0||root.children==null) return true;
        else if (root.children.size()==1) return root.children.get(0).data< root.data && isMaxBinaryHeap(root.children.get(0));
        else return root.children.get(0).data<root.data
                    && root.children.get(1).data< root.data
                    && isMaxBinaryHeap(root.children.get(0))
                    && isMaxBinaryHeap(root.children.get(1));
    }

    static int height(Node root) {
        if (root==null) return -1;
        int maxHeight =-1;
        for (Node i:root.children){
            int height=height(i);
            if (maxHeight<height) maxHeight=height;
        }
        return 1+maxHeight;
    }

    static void print(Node root) {
    	// In cây theo từng tầng một
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp= queue.poll();
            if (temp!=null){
                queue.addAll(temp.children);
            }

            System.out.println(temp);
        }
    }

    static public void preorder(Node root) {
        if (root==null) return;
        System.out.println(root);
        for (Node i:root.children){
            postorder(i);
        }
    }

    static public void postorder(Node root) {
        if (root==null) return;
        for (Node i:root.children){
            preorder(i);
        }
        System.out.println(root);
    }

    public static void main(String[] args) {
        Tree a = new Tree();
        a.root= new Node(1,null,new ArrayList<>());
        insertNode(a.root,1,2);
        insertNode(a.root,1,3);
        insertNode(a.root,2,4);
        insertNode(a.root,2,5);
        insertNode(a.root,3,6);
        insertNode(a.root,3,7);
        preorder(a.root);
        System.out.println(height(a.root));
    }
}