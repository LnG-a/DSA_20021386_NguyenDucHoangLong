import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private List<List<Node>> adj;

    private class Node {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.cost = cost;
            this.vertex = vertex;
        }
    }

    public Graph(int V) {
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addVertex(int vertex) {
        for (int i = adj.size(); i <= vertex; i++) {
            if (i < vertex) adj.add(null);
            else adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int v1, int v2, int cost) {
        if (v1 > adj.size() || v2 > adj.size() || adj.get(v1) == null || adj.get(v2) == null) return;
        Node vertex1 = new Node(v1, cost);
        Node vertex2 = new Node(v2, cost);
        adj.get(v1).add(vertex2);
        adj.get(v2).add(vertex1);
    }

    public void removeVertex(int v1) {
        if (v1 > adj.size() || adj.get(v1) == null) return;
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i) != null) {
                for (int j = 0; j < adj.get(i).size(); j++) {
                    if (adj.get(i).get(j).vertex == v1) adj.get(i).remove(j);
                }
            }
        }
        if (v1 == adj.size() - 1) {
            adj.remove(v1);
            for (int i = adj.size() - 2; i > 0; i--) {
                if (adj.get(i) == null) adj.remove(i);
                else break;
            }
        }
    }

    public void removeEdge(int v1, int v2, int cost) {
        if (v1 > adj.size() || v2 > adj.size() || adj.get(v1) == null || adj.get(v2) == null) return;
        for (int i = 0; i < adj.get(v1).size(); i++) {
            if (adj.get(v1).get(i).vertex == v2 && adj.get(v1).get(i).cost == cost) {
                adj.remove(i);
            }
        }
        for (int i = 0; i < adj.get(v2).size(); i++) {
            if (adj.get(v2).get(i).vertex == v1 && adj.get(v2).get(i).cost == cost) {
                adj.remove(i);
            }
        }
    }

    public boolean hasEdgeBetween(int v1, int v2) {
        if (v1 > adj.size() || v2 > adj.size() || adj.get(v1) == null || adj.get(v2) == null) return false;
        for (int i = 0; i < adj.get(v1).size(); i++) {
            if (adj.get(v1).get(i).vertex == v2) return true;
        }
        return false;
    }

    public int[] getAdjVertex(int v) {
        int[] a = new int[adj.get(v).size()];
        for (int i = 0; i < adj.get(v).size(); i++) {
            a[i] = adj.get(v).get(i).vertex;
        }
        return a;
    }

    public Node[] getAdjNode(int v){
        Node[] a = new Node[adj.get(v).size()];
        for (int i = 0; i < adj.get(v).size(); i++) {
            a[i] = adj.get(v).get(i);
        }
        return a;
    }

    public class DepthFirstSearch {
        private boolean[] marked;
        private int[] edgeTo;
        private int[] cost;
        private int s;

        public DepthFirstSearch(Graph G, int s) {
            marked = new boolean[G.adj.size()];
            edgeTo = new int[G.adj.size()];
            for (int i = 0; i < G.adj.size(); i++) {
                marked[i] = false;
            }
            dfs(G, s);
        }

        private void dfs(Graph G, int v) {
            marked[v] = true;
            for (int w : G.getAdjVertex(v)) {
                if (!marked[w]) {
                    dfs(G, w);
                    edgeTo[w] = v;
                }
            }
        }
    }

    public class BreadthFirstSearch{
        private boolean[] marked;
        private int []edgeTo;
        private int []distanceTo;

        BreadthFirstSearch(Graph G,int s){
            marked = new boolean[G.adj.size()];
            edgeTo = new int[G.adj.size()];
            distanceTo =  new int[G.adj.size()];
            for (int i = 0; i < G.adj.size(); i++) {
                marked[i] = false;
            }
            Queue<Integer> queue=new LinkedList<>();
            queue.add(s);
            marked[s]=true;
            distanceTo[s]=0;

            while (!queue.isEmpty()){
                int v=queue.poll();
                for (Node w: G.getAdjNode(v)){
                    if (!marked[w.vertex]) {
                        queue.add(w.vertex);
                        marked[w.vertex]=true;
                        edgeTo[w.vertex]=v;
                        distanceTo[w.vertex]=distanceTo[v]+w.cost;
                    }
                }
            }
        }
    }
}
