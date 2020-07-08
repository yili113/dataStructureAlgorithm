package cqupt.interviewQ.ProCon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yiLi
 * @create 2020-07-07 10:48
 */
public class V3PC {
    public static void main(String[] args) throws InterruptedException {
        V3Data data = new V3Data();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();
        TimeUnit.SECONDS.sleep(2);
    }
}
class V3Data {
    AtomicInteger number = new AtomicInteger();
    BlockingQueue<Integer> queue = new ArrayBlockingQueue(1);

    public void increment() throws InterruptedException {// 生产数据,往队列中添加
        int curNum = number.incrementAndGet();
        boolean success = queue.offer(curNum, 2, TimeUnit.SECONDS);
        if(success)
            System.out.println(Thread.currentThread().getName() + "添加数据" + curNum + "成功");
        else
            System.out.println(Thread.currentThread().getName() + "添加数据" + curNum + "失败");
        TimeUnit.SECONDS.sleep(2);
    }

    public void decrement() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        Integer curNum = queue.poll(2, TimeUnit.SECONDS);
        if (curNum != null)
            System.out.println(Thread.currentThread().getName() + "取数据" + curNum + "成功");
        else
            System.out.println(Thread.currentThread().getName() + "取数据" + curNum + "失败");
        TimeUnit.SECONDS.sleep(1);
    }
}
