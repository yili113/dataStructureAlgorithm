package cqupt.interviewQ.container;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Liyi
 * @create 2020-05-04 15:27
 */
public class ContainerNoSafeDemo {

    public static void main(String[] args) {
        arrayListUnSafe();
        arrayListSafe();
    }

    private static void arrayListUnSafe() {
        List list = new ArrayList();
        for (int i = 0; i < 40; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
    }

    private static void arrayListSafe() {
        //        List<Object> list = new Vector<>();
//        List list = Collections.synchronizedList(new ArrayList<>());
        List list = new CopyOnWriteArrayList();
        for (int i = 0; i < 40; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
    }
}
