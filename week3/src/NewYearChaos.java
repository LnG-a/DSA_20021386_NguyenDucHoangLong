import java.util.Arrays;
import java.util.List;

public class NewYearChaos {
    public static void main(String[] args) {
        Integer[] a=new Integer[] {3,2,5,4,7,1,6,10,9,8};
        List<Integer> list= Arrays.asList(a);
        newYearChaos(list);
        newYearChaos2(list);
    }

    /**
     * This method resolve NewYearChaos algorithm.
     * Complexity(N^2)
     *
     * @param arr an int list
     */
    public static void newYearChaos(List<Integer> arr) {
        int count=0;
        for (int i=0;i<arr.size();i++){
            if (arr.get(i)-(i+1)>2){
                System.out.println("Too chaotic");
                return;
            }
            for (int j=Math.max(0, arr.get(i)-2);j<i;j++){
                if (arr.get(j)>arr.get(i)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    /**
     * This method resolve NewYearChaos algorithm.
     * Complexity(N^2)
     *
     * @param arr an int list
     */
    public static void newYearChaos2(List<Integer> arr) {
        int count=0;
        for (int i=0;i<arr.size();i++){
            if (arr.get(i)-(i+1)>2){
                System.out.println("Too chaotic");
                return;
            }
            for (int j=i+1;j< arr.size();j++){
                if (arr.get(j)<arr.get(i)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
