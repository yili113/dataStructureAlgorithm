package cqupt.luban.synchronizedDemo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Liyi
 * @create 2020-03-23 9:52
 */
public class Demo6 {
    AtomicInteger count = new AtomicInteger(0);
    public void test() {
        for (int i = 0; i < 10000; i++) {
            if (count.get() < 1000) {
                count.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) {
        Demo6 demo6 = new Demo6();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(demo6::test,"t-" + i));
        }
        threads.forEach((o) -> o.start());// 启动threads中的线程
        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(demo6.count);
    }
}
