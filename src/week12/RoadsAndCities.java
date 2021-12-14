import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class RoadsAndCities {
    public static class Graph{
        private final int V;
        private List<List<Integer>> adj;

        public Graph(int V){
            this.V=V;
            adj=new ArrayList<>();
            for (int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int v,int w){
            adj.get(v).add(w);
            adj.get(w).add(v);
        }

        public List<Integer> adj(int v){
            return adj.get(v);
        }
    }

    public static class CC{
        private List<Boolean> marked;
        private List<Integer> id;
        private int count=0;

        public CC(Graph G){
            marked= new ArrayList<>(G.V);
            id=new ArrayList<>(G.V);
            for (int i=0;i<G.V;i++){
                marked.add(false);
                id.add(-1);
            }
            for (int i=0;i<G.V;i++){
                if (!marked.get(i)){
                    dfs(G,i);
                    count++;
                }
            }
        }

        public int getCount() {
            return count;
        }

        public int id(int v){
            return id.get(v);
        }

        public boolean connected(int v,int w){
            return id.get(v)==id.get(w);
        }

        private void dfs(Graph G, int v) {
            marked.set(v,true);
            id.set(v,count);
            for (int w:G.adj(v)){
                if (!marked.get(w)) dfs(G,w);
            }

        }

    }

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
        if (c_lib<=c_road) {
            return c_lib*n;
        }
        Graph graph= new Graph(n);
        for (int i=0;i<cities.size();i++){
            cities.get(i).set(0,cities.get(i).get(0)-1);
            cities.get(i).set(1,cities.get(i).get(1)-1);
            graph.addEdge(cities.get(i).get(0),cities.get(i).get(1));
        }

        CC connectedComponent=new CC(graph);

        long minCost=c_lib* connectedComponent.getCount()+c_road*(n-connectedComponent.getCount());

        return minCost;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
