package week9;

import java.util.*;

public class ShortestPath {
    static class Node implements Comparable<Node> {
        public int value;
        public int cost;

        public Node(int node,int cost) {
            this.value=node;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.cost,o.cost);
        }
    }
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        s--;

        Integer[] distance = new Integer[n];
        Arrays.fill(distance,-1);

        Set<Integer> visited= new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(n);

        List<List<Node>> adj= new ArrayList<>();
        for (int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        edges.forEach(e -> {
            adj.get(e.get(0)-1).add(new Node(e.get(1)-1,e.get(2)));
            adj.get(e.get(1)-1).add(new Node(e.get(0)-1,e.get(2)));
        });

        pq.add(new Node(s,0));
        distance[s]=0;

        while (visited.size()!=n){
            if (pq.isEmpty()) break;

            int u=pq.poll().value;
            if (visited.contains(u)){
                continue;
            }
            visited.add(u);

            for (Node v:adj.get(u)){
                if (!visited.contains(v.value)) {
                    int newDistance = distance[u]+v.cost;
                    if (distance[v.value]==-1||newDistance<distance[v.value]) distance[v.value]=newDistance;
                    pq.add(new Node(v.value,distance[v.value]));
                }
            }
        }

        ArrayList<Integer> r = new ArrayList<>(n-1);
        for (int i=0;i<n;i++){
            if (i!=s) r.add(distance[i]);
        }

        return r;
    }

}
