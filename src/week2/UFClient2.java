package week2;

import edu.princeton.cs.algs4.*;


public class UFClient2 {
    public static void main(String[] args) {
        int count = 0;
        int work =0;
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(!uf.connected(p,q)){
                uf.union(q, p);
                work++;
                count++;
            }
            else count++;
            if (work==N-1) {
                StdOut.println(count);
                break;
            }
        }
        if (work<N-1) StdOut.println("Failed");

    }

}
//javac -cp D:\E-Learning\CTDLGT\algs4.jar;. UFCLient2.java
//java -cp D:\E-Learning\CTDLGT\algs4.jar;. week2.UFClient2
//java -cp D:\E-Learning\CTDLGT\algs4.jar;. week2.UFClient2 <D:\E-Learning\CTDLGT\algs4-data\tinyUF.txt