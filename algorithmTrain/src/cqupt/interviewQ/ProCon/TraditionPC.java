package cqupt.interviewQ.ProCon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yiLi
 * @create 2020-07-06 22:01
 */
public class TraditionPC {


    public static void main(String[] args) {
        // 定义资源类
        ShareData data = new ShareData();
//        for (int i = 0; i < 3; i++) {
//            new Thread(() -> {
//                data.increment();
//            }).start();
//        }
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "t1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "t2").start();
    }
}
class ShareData{
    private int number;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment() {// 生产方法
        lock.lock();;
        try {
            while (number != 0)
                condition.await();// 只要还有就不能生产
            number ++;// 生产+1
            System.out.println(Thread.currentThread().getName() + "生产了:" + number);
            // 唤醒消费线程
            condition.signal();
        }catch (Exception e) {
            System.out.println("异常");
        }finally {
            lock.unlock();
        }
    }
    public void decrement() {
        lock.lock();
        try {
            while (number == 0)
                condition.await();
            number --;
            System.out.println(Thread.currentThread().getName() + "消费了:" + number);
            condition.signal();
        }catch (Exception e) {
            System.out.println("消费线程异常");
        }finally {
            lock.unlock();
        }
    }
}
