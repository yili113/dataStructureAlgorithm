package cqupt.interviewQ.reference;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author Liyi
 * @create 2020-05-07 17:50
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
//        myWeakHashMap();
        myHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "weakHashMap";
        map.put(key, value);
        System.out.println(map);
        key = null;
        System.out.println(map);
        System.gc();
        System.out.println(map +"\t"+ map.size());
        System.out.println("*************");
    }

    private static void myHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "hashMap";
        map.put(key, value);
        System.out.println(map);
        key = null;
        System.out.println(map);
        System.gc();
        System.out.println(map +"\t"+ map.size());
    }
}
