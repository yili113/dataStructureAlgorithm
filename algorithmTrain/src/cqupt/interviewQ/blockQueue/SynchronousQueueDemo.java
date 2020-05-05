package cqupt.interviewQ.blockQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Liyi
 * @create 2020-05-05 15:46
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "线程正在put数据1");
                blockingQueue.put(1);
                System.out.println(Thread.currentThread().getName() + "线程正在put数据2");
                blockingQueue.put(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(Thread.currentThread().getName() + "线程正在取数据" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(3);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(Thread.currentThread().getName() + "线程正在取数据" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
