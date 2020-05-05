package cqupt.interviewQ.blockQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Liyi
 * @create 2020-05-05 16:16
 */
public class TraditionalProCon {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 1; i <= 3; i++) {// 一个线程负责生产,一共生产3个
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();
        new Thread(() -> {// 一个线程负责消费
            for (int i = 1; i <= 3; i++) {
                shareData.decrement();
            }
        }, "t2").start();
    }
}
class ShareData {
    private int number;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            // 1.判断
            while (number != 0) {// number为0时候就等待,一定要用while判断
                condition.await();
            }
            // 2.干活
            number ++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3.通知唤醒
            condition.signalAll();// 通知其他线程当前线程用完了锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrement() {
        lock.lock();
        try {
            // 1.判断
            while (number == 0) {
                condition.await();
            }
            // 2.干活
            number --;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3.通知唤醒
            condition.signalAll();// 通知其他线程当前线程用完了锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}