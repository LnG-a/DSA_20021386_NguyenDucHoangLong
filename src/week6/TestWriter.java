package week6;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdRandom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestWriter {
    public static void ascending(String path, int size) {
        List<Integer> a=new ArrayList<>();
        for (int i=1;i<=size;i++){
            a.add(i);
        }
        writeFile(path,a);
    }

    public static void descending(String path, int size) {
        List<Integer> a=new ArrayList<>();
        for (int i=size;i>=1;i--){
            a.add(i);
        }
        writeFile(path,a);
    }

    public static void random(String path, int size) {
        List<Integer> a=new ArrayList<>();
        for (int i=size;i>=1;i--){
            a.add(StdRandom.uniform(size));
        }
        writeFile(path,a);
    }

    public static void fewUnique(String path, int size) {
        List<Integer> a=new ArrayList<>();
        for (int i=size;i>=1;i--){
            a.add(StdRandom.uniform(size/100));
        }
        writeFile(path,a);
    }


    private static void writeFile(String path, List<Integer> a) {
        try {
        File del = new File(path);
        del.delete();
        File dictFile = new File(path);
        dictFile.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Out printer = new Out(path);
        for (int i=0;i<a.size();i++){
            printer.println(a.get(i));
        }
    }

    public static void main(String[] args) {
        ascending("32kAscending.txt",32000);
        descending("32kDescending.txt",32000);
        random("32kRandom.txt",32000);
        fewUnique("32kFewUnique.txt",32000);
        ascending("1kAscending.txt",1000);
        descending("1kDescending.txt",1000);
        random("1kRandom.txt",1000);
        fewUnique("1kFewUnique.txt",1000);
        ascending("100kAscending.txt",100000);
        descending("100kDescending.txt",100000);
        random("100kRandom.txt",100000);
        fewUnique("100kFewUnique.txt",100000);
        /*ascending("2kAscending.txt",16568);
        descending("2kDescending.txt",16001);*/
    }
}
