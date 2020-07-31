package cqupt.interviewQ.reference;

import java.lang.reflect.Field;

/**
 * @author yiLi
 * @create 2020-07-28 20:18
 */
public class ThreadLocalDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
//        Thread t = new Thread(()->test("abc",false));
//        t.start();
//        t.join();
//        System.out.println("--gc后--");
//        Thread t2 = new Thread(() -> test("def", true));
//        t2.start();
//        t2.join();
        Thread t = new Thread(() -> {
            ThreadLocal<Integer> local = new ThreadLocal<>();
            ThreadLocal<Double> local1 = new ThreadLocal<>();
            local.set(1);
            local.set(2);
            local.set(3);
            local1.set(1.1);
            System.out.println();
            System.out.println(local.get());
            System.out.println(local1.get());
        }, "t1");
    }

    private static void test(String s,boolean isGC)  {
        try {
            new ThreadLocal<>().set(s);
            if (isGC) {
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object ThreadLocalMap = field.get(t);
            Class<?> tlmClass = ThreadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(ThreadLocalMap);
            System.out.println(arr.length);
            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
                    System.out.println("***");
                    //                    System.out.println(referenceField.get(o));
//                    System.out.println(valueField.get(o));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
