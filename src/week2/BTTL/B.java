
public class B {
    public static void main(String[] args) {
        int x=1,y=2;
        System.out.println(A.sum(x,y));
        System.out.println(A.sum(A.square(x),A.square(y)));
    }
}
