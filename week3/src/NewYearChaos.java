import java.util.Arrays;
import java.util.List;

public class NewYearChaos {
    public static void main(String[] args) {
        Integer[] a=new Integer[] {3,2,5,4,7,1,6,8};
        List<Integer> list= Arrays.asList(a);
        newYearChaos(list);
    }

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
}
