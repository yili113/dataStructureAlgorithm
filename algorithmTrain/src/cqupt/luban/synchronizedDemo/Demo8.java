package cqupt.luban.synchronizedDemo;

import java.util.concurrent.TimeUnit;

/**
 * @author Liyi
 * @create 2020-03-23 15:41
 */
public class Demo8 {
    String s1 = "hello";
    String s2 = "hello";
    public void test1() {
        synchronized (s1) {
            System.out.println("s1  start-----");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("s1  end-----");
        }
    }
    public void test2() {
        synchronized (s2) {
            System.out.println("s2  start************");
        }
    }
    public static void main(String[] args) {
        Demo8 demo8 = new Demo8();
        new Thread(demo8::test1, "t1").start();
        new Thread(demo8::test2, "t2").start();// t2和t1持有的是同一把锁吗？
    }
}
