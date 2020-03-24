package cqupt.luban.synchronizedDemo;

import java.util.concurrent.TimeUnit;

/**
 * @author Liyi
 * @create 2020-03-23 15:28
 */
public class Demo7 {
    Object o = new Object();
    public void  test() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        Demo7 demo7 = new Demo7();
        new Thread(demo7::test, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo7.o= new Object();
        new Thread(demo7::test, "t2").start();// t2线程会执行吗？
    }
}
