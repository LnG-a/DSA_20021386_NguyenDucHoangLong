import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class ShortestReach {
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        List<Integer> distance= new ArrayList<>();
        s--;
        for (int i=0;i<edges.size();i++){
            for (int j=0;j<2;j++){
                edges.get(i).set(j,edges.get(i).get(j)-1);
            }
        }

        for (int i=0;i<n;i++){
            distance.add(-1);
        }
        distance.set(s,0);

        int countDistance=0;
        boolean change=true;

        while (change){
            change=false;
            for (int j=0;j<distance.size();j++){
                if (distance.get(j)==countDistance){
                    for (int i=0;i<edges.size();i++){
                        if (edges.get(i).get(0)==j){
                            distance.set(edges.get(i).get(1),distance.get(j)+6);
                            edges.remove(i);
                            change=true;
                        }
                        else if (edges.get(i).get(1)==j){
                            distance.set(edges.get(i).get(0),distance.get(j)+6);
                            edges.remove(i);
                            change=true;
                        }
                    }
                }
            }
            countDistance+=6;
        }

        distance.remove(s);
        return distance;
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

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = bfs(n, m, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
