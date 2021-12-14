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


public class ConnectedCells {
    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here

        int max =0;
        for (int i=0;i<matrix.size();i++){
            for (int j=0;j<matrix.get(i).size();j++){
                if (matrix.get(i).get(j)==1) {
                    int cnt = cnt(i, j, matrix);
                    if (max < cnt) max = cnt;
                    System.out.println(cnt);
                }
            }
        }
        return max;
    }

    private static int cnt(int row, int col,List<List<Integer>> matrix){
        if (row<0||col<0||row>=matrix.size()||col>=matrix.get(row).size()) return 0;
        if (matrix.get(row).get(col)==0) return 0;
        int count=1;
        matrix.get(row).set(col,0);
        for (int i=row-1;i<=row+1;i++){
            for (int j=col-1;j<=col+1;j++){
                if (i!=row||j!=col) {
                    count += cnt(i, j, matrix);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
 