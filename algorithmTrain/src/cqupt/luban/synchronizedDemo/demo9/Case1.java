package cqupt.luban.synchronizedDemo.demo9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Liyi
 * @create 2020-03-23 15:56
 * 面试题：给一个list提供add和size方法，实现线程1循环向list加入10个元素,线程2监控list大小，当大小为5时，结束线程2并给出提示。
 */
public class Case1 {
    volatile List list = new ArrayList();
    public void add(Object o) {
        list.add(o);
    }
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Case1 c = new Case1();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                c.add(new Object());
                System.out.println("添加第"+ i +"个对象");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();
        new Thread(() -> {
            while (true) {
                if (c.size() == 5)
                    break;
            }
            System.out.println("t2结束---");
        }, "t2").start();
    }
}
