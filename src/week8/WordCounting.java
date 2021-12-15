package week8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordCounting {
    public static void main(String[] args) {
        Scanner a= new Scanner(System.in);
        String s=a.nextLine();
        /*while (s.charAt(0)==' '){
            s.substring(1);
        }*/
        List<String> stringList=new ArrayList<>();
        for (int i=0;i<s.length();i++){
            String b="";
            while (i<s.length()&&s.charAt(i)!=' '){
                b=b.concat(String.valueOf(s.charAt(i)));
                i++;
            }
            stringList.add(b);
        }
        Collections.sort(stringList);
        int count=1;
        for (int i=0;i<stringList.size()-1;i++){
            if (stringList.get(i).equals(stringList.get(i+1))){
                count++;
            } else {
                System.out.println(stringList.get(i)+" "+count);
                count =1;
            }
            if (i==stringList.size()-2){
                System.out.println(stringList.get(i+1)+" "+count);
            }
        }

    }

}
