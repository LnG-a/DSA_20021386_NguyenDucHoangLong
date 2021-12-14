import java.util.LinkedList;
import java.util.Queue;

public class Tree_LevelOrderTraversal {
    class Node {
        int data;
        Node left;
        Node right;
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp= queue.poll();
            if (temp.left!= null) queue.add(temp.left);
            if (temp.right!= null) queue.add(temp.right);
            System.out.print(temp.data+" ");
        }
    }
}
