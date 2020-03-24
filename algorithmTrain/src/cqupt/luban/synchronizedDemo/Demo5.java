package cqupt.luban.synchronizedDemo;

import java.util.concurrent.TimeUnit;

/**
 * @author Liyi
 * @create 2020-03-23 9:13
 */
public class Demo5 {
    boolean running = true;
//    volatile boolean running = true;// volatile保证了各线程间的可见性
    public void test() {
        System.out.println("test start");
        while (running) {
            System.out.println("....");
        }
        System.out.println("test end");
    }

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5();
        new Thread(demo5::test, "t1").start();// 启动t1线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo5.running = false;
    }
}
