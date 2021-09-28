public class NewYearChaos {
    public static void main(String[] args) {
        int[] a=new int[] {3,2,5,4,7,1,6,8};
        newYearChaos(a);
    }

    public static void newYearChaos(int[] a) {
        int count=0;
        for (int i=0;i<a.length;i++){
            if (a[i]-(i+1)>2){
                System.out.println("Too chaotic");
                return;
            }
            for (int j=Math.max(0,a[i]-2);j<i;j++){
                if (a[j]>a[i]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
