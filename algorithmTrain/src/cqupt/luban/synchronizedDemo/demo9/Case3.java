package cqupt.luban.synchronizedDemo.demo9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Liyi
 * @create 2020-03-23 16:44
 */
public class Case3 {
    List list = new ArrayList();
    public void add(Object o) {
        list.add(o);
    }
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Case3 c = new Case3();
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            if (c.size() != 5) {
                try {
                    latch.await();// 只要size不是5,t2就等待,只要latch一给出唤醒消息,立马就能醒过来
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 end**********");
        }).start();
        new Thread(() -> {
            System.out.println("t1 start********");
            for (int i = 1; i <= 10; i++) {
                if (c.size() == 5)
                    latch.countDown();
                c.add(new Object());
                System.out.println("添加第" + i + "个对象");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
