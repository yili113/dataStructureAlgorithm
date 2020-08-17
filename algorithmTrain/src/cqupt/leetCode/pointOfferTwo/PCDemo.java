package cqupt.leetCode.pointOfferTwo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yiLi
 * @create 2020-08-14 10:48
 */
public class PCDemo {

    public static void main(String[] args) {
        DataPC data = new DataPC();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                data.increment();
            }).start();
        }
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                data.decrement();
            }).start();

        }
    }
}
class DataPC {
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
    private AtomicInteger number = new AtomicInteger();

    public void increment() {
        int cur = number.incrementAndGet();
        try {
            boolean flag = queue.offer(cur, 2, TimeUnit.SECONDS);
            if (flag)
                System.out.println("添加" + cur + "成功");
            else
                System.out.println("添加" + cur + "失败");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void decrement() {
        try {
            TimeUnit.SECONDS.sleep(1);
            Integer cur = queue.poll(2, TimeUnit.SECONDS);
            System.out.println("队列取出值：" + cur);
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
