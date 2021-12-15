package week9;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        /*week9.MaxTreeHeap a= new week9.MaxTreeHeap();
        a.insert(1);
        a.insert(3);
        a.insert(2);
        System.out.println(a.peak());*/
        Map a = new HashMap();
        a.put("long",2);
        a.put("hien",1);
        a.put("love",3);
        System.out.println(a);
        a.put("long",10);
        System.out.println(a);

    }
}
