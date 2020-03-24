package cqupt.luban.synchronizedDemo.demo9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Liyi
 * @create 2020-03-23 16:33
 */
public class Case2 {
    List list = new ArrayList();
    public void add(Object o) {
        list.add(o);
    }
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Case2 c = new Case2();
        Object lock = new Object();
        new Thread(() -> {// 先启动t2
            synchronized (lock) {
                if (c.size() != 5) {
                    try {
                        lock.wait();// 只要size没到5,t2线程就等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 end***********");
                lock.notify();
            }
        }).start();
        new Thread(() -> {
            System.out.println("t1 start*****");
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    if (c.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    c.add(new Object());
                    System.out.println("添加第" + i + "个对象");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
