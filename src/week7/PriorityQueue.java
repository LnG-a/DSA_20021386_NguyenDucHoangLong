package week7;

public class PriorityQueue {
    int[] a=new int[100];
    int dem=0;

    public void insert(int number){
        a[dem]=number;
        dem++;
    }

    public int deleteMin(){
      if(dem>0) {
            int min = 0;
            for (int i=0;i<dem;i++){
                if (a[min]>a[i]) min=i;
            }
            int min_value=a[min];
            a[min]=a[dem-1];
            dem--;
            return min_value;
      }
      return Integer.MIN_VALUE;
    }
}
