import java.util.Arrays;
import java.util.List;

public class EqualStacks {
    /**
     * This method finds the highest equal point.
     *
     * @param h1 a List of Integer
     * @param h2 a List of Integer
     * @param h3 a List of Integer
     * @return
     */
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        long sum1=sum(h1);
        long sum2=sum(h2);
        long sum3=sum(h3);
        int dem1=0;
        int dem2=0;
        int dem3=0;
        while (sum1!=sum2&&sum2!=sum3){
            long max=Math.max(sum1,Math.max(sum2,sum3));
            if (sum1==max){
                sum1-=h1.get(dem1);
                dem1++;
            }
            if (sum2==max){
                sum2-=h2.get(dem2);
                dem2++;
            }
            if (sum3==max){
                sum3-=h3.get(dem3);
                dem3++;
            }
        }
        return (int)sum1;
    }

    private static long sum(List<Integer> list){
        int sum =0;
        for (int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Integer[] a={3,2,1,1,1};
        Integer[] b={4,3,2};
        Integer[] c={1,1,4,1};
        List<Integer> a_ = Arrays.asList(a);
        List<Integer> b_ = Arrays.asList(b);
        List<Integer> c_ = Arrays.asList(c);
        System.out.println(equalStacks(a_,b_,c_));
    }
}
