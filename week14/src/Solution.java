import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int[] money=  new int[]{1,2,5,10,20,50};

    public static void main(String[] args) {
        /*String s1="abcaaa";
        String s2="aecbaacd";
        System.out.println(dynamicLcs(s1,s2));*/
        int[] N = new int[]{1,0,2,2,4,1};
        int v=83;
        System.out.println(dynamicATM(N,v));
    }
    // 1 2 5 10 20 50
    public static int recursiveATM(int[] N,int v){
        int chooseMoney=N.length-1;
        while (chooseMoney>=0&& N[chooseMoney]==0) {
            chooseMoney--;
        }

        if (v==0) return 0;
        if (chooseMoney==-1) return 100;

        N[chooseMoney]--;

        if (v>=money[chooseMoney]) {
            /*if (case1>0 && case2 >0) {
                return Math.min(case1,case2);
            } else return case1;*/
            int case1=1+recursiveATM(N,v-money[chooseMoney]);
            int case2=recursiveATM(N,v);
            return Math.min(case1,case2);
            //return case1;
        } else return recursiveATM(N,v);
    }

    public static int dynamicATM(int[] N,int v){
        List<Integer> totalMoney= new ArrayList();
        for (int i=0;i<N.length;i++){
            for (int j=0;j<N[i];j++){
                totalMoney.add(money[i]);
            }
        }
        System.out.println(totalMoney);
        System.out.println(v);
        int[][] matrix=new int[totalMoney.size()+1][v+1];
        for (int i=0;i<totalMoney.size()+1;i++){
            for (int j=0;j<v+1;j++){
                if (i*j==0) matrix[i][j]=0;
                else if (j>=totalMoney.get(i-1)) {
                    matrix[i][j]=1+matrix[i-1][j-totalMoney.get(i-1)];
                } else matrix[i][j]=matrix[i-1][j];
            }
        }
        /*for (int i=0;i< totalMoney.size()+1;i++){
            for (int j=0;j<v+1;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }*/
        return matrix[totalMoney.size()][v];
    }

    public static int recursiveLcs(String string1, String string2){
        if (string1.length()*string2.length()==0) return 0;
        if (string1.charAt(0)==string2.charAt(0)){
            return 1+(recursiveLcs(string1.substring(1),string2.substring(1)));
        } else {
            return Math.max(recursiveLcs(string1,string2.substring(1)), recursiveLcs(string1.substring(1),string2));
        }
    }

    public static int dynamicLcs(String string1, String string2){
        int[][] matrix=new int[string1.length()+1][string2.length()+1];
        for (int i =0;i<string1.length()+1;i++){
            for (int j=0;j<string2.length()+1;j++){
                if (i*j==0) matrix[i][j]=0;
                else if (string1.charAt(i-1)==string2.charAt(j-1)) matrix[i][j]=1+matrix[i-1][j-1];
                else matrix[i][j]=Math.max(matrix[i-1][j],matrix[i][j-1]);
            }
        }
        return matrix[string1.length()][string2.length()];
    }
}
